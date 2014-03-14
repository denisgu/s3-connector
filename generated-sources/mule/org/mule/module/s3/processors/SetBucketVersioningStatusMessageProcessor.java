
package org.mule.module.s3.processors;

import java.util.List;
import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.processor.MessageProcessor;
import org.mule.module.s3.S3Connector;
import org.mule.module.s3.connectivity.S3ConnectorConnectionManager;
import org.mule.module.s3.simpleapi.VersioningStatus;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * SetBucketVersioningStatusMessageProcessor invokes the {@link org.mule.module.s3.S3Connector#setBucketVersioningStatus(java.lang.String, org.mule.module.s3.simpleapi.VersioningStatus)} method in {@link S3Connector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.0-M4", date = "2014-03-14T11:58:02-05:00", comments = "Build M4.1875.17b58a3")
public class SetBucketVersioningStatusMessageProcessor
    extends AbstractConnectedProcessor
    implements MessageProcessor
{

    protected Object bucketName;
    protected String _bucketNameType;
    protected Object versioningStatus;
    protected VersioningStatus _versioningStatusType;

    public SetBucketVersioningStatusMessageProcessor(String operationName) {
        super(operationName);
    }

    /**
     * Obtains the expression manager from the Mule context and initialises the connector. If a target object  has not been set already it will search the Mule registry for a default one.
     * 
     * @throws InitialisationException
     */
    public void initialise()
        throws InitialisationException
    {
    }

    @Override
    public void start()
        throws MuleException
    {
        super.start();
    }

    @Override
    public void stop()
        throws MuleException
    {
        super.stop();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    /**
     * Sets versioningStatus
     * 
     * @param value Value to set
     */
    public void setVersioningStatus(Object value) {
        this.versioningStatus = value;
    }

    /**
     * Sets bucketName
     * 
     * @param value Value to set
     */
    public void setBucketName(Object value) {
        this.bucketName = value;
    }

    /**
     * Invokes the MessageProcessor.
     * 
     * @param event MuleEvent to be processed
     * @throws Exception
     */
    public MuleEvent doProcess(final MuleEvent event)
        throws Exception
    {
        Object moduleObject = null;
        try {
            moduleObject = findOrCreate(S3ConnectorConnectionManager.class, true, event);
            final String _transformedBucketName = ((String) evaluateAndTransform(getMuleContext(), event, SetBucketVersioningStatusMessageProcessor.class.getDeclaredField("_bucketNameType").getGenericType(), null, bucketName));
            final VersioningStatus _transformedVersioningStatus = ((VersioningStatus) evaluateAndTransform(getMuleContext(), event, SetBucketVersioningStatusMessageProcessor.class.getDeclaredField("_versioningStatusType").getGenericType(), null, versioningStatus));
            ProcessTemplate<Object, Object> processTemplate = ((ProcessAdapter<Object> ) moduleObject).getProcessTemplate();
            processTemplate.execute(new ProcessCallback<Object,Object>() {


                public List<Class<? extends Exception>> getManagedExceptions() {
                    return null;
                }

                public boolean isProtected() {
                    return false;
                }

                public Object process(Object object)
                    throws Exception
                {
                    ((S3Connector) object).setBucketVersioningStatus(_transformedBucketName, _transformedVersioningStatus);
                    return null;
                }

            }
            , this, event);
            return event;
        } catch (Exception e) {
            throw e;
        }
    }

}