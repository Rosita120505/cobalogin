package com.rositasrs.cobalogin.repository;

import com.rositasrs.cobalogin.model.entity.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadFileRepository extends JpaRepository<UploadFile, String> {
}
