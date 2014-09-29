package com.linkedin.gradle.liazkaban;

import com.linkedin.gradle.azkaban.PigJob;

/**
 * Extend the Hadoop Plugin Azkaban Job classes with the LinkedIn-specific "pigLi" job type.
 */
class PigLiJob extends PigJob {

  PigLiJob(String jobName) {
    super(jobName);
  }

  // Override the job type with the LinkedIn-specific pigLi type.
  Map<String, String> buildProperties(Map<String, String> allProperties) {
    super.buildProperties(allProperties);
    allProperties["type"] = "pigLi";
    return allProperties;
  }

  // We have to additionally override the clone methods.
  PigLiJob clone() {
    return clone(new PigLiJob(name));
  }

  PigLiJob clone(PigLiJob cloneJob) {
    cloneJob.parameters.putAll(parameters);
    cloneJob.script = script;
    return super.clone(cloneJob);
  }
}
