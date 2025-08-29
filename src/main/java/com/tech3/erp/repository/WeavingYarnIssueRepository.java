// package com.tech3.erp.repository;

// import com.tech3.erp.entity.YarnRequirement;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// @Repository
// public interface YarnRequirementRepository extends JpaRepository<YarnRequirement, Long> {}

package com.tech3.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech3.erp.entity.WeavingYarnIssue;

@Repository
public interface WeavingYarnIssueRepository extends JpaRepository<WeavingYarnIssue, Long> {
}