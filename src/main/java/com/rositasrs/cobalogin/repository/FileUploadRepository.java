package com.rositasrs.cobalogin.repository;

import com.rositasrs.cobalogin.model.entity.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRepository extends JpaRepository<FileUpload, String> {
}
