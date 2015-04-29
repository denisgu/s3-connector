/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is
 * published under the terms of the CPAL v1.0 license, a copy of which
 * has been included with this distribution in the LICENSE.md file.
 */

package org.mule.module.s3.automation.testcases;

import com.amazonaws.services.s3.model.Bucket;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.module.s3.automation.RegressionTests;
import org.mule.module.s3.automation.S3TestParent;
import org.mule.module.s3.automation.SmokeTests;
import org.mule.modules.tests.ConnectorTestUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ListBucketsTestCases extends S3TestParent {

    private List<String> generatedBucketNames = new ArrayList<String>();
    private List<String> retrievedBucketNames = new ArrayList<String>();

    @Before
    public void setUp() throws Exception {

        initializeTestRunMessage("listBucketsTestData");
        generatedBucketNames.add((String) getTestRunMessageValue("bucketName"));
        runFlowAndGetPayload("create-bucket");
    }

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testListBuckets() {

        try {
            List<Bucket> buckets = (List<Bucket>) runFlowAndGetPayload("list-buckets");
            Iterator<Bucket> iterator = buckets.iterator();
            while (iterator.hasNext()) {
                Bucket bucket = iterator.next();
                retrievedBucketNames.add(bucket.getName());
            }
            assertTrue(retrievedBucketNames.containsAll(generatedBucketNames));
        } catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }

    @After
    public void tearDown() throws Exception {
        runFlowAndGetPayload("delete-bucket");
    }
}