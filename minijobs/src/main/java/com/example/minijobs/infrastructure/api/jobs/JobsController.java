package com.example.minijobs.infrastructure.api.jobs;

import com.example.minijobs.domain.jobs.entity.Job;
import com.example.minijobs.domain.jobs.exception.NoCreditsException;
import com.example.minijobs.domain.jobs.exception.UnknownUserException;
import com.example.minijobs.domain.jobs.usecase.FindJobs;
import com.example.minijobs.infrastructure.api.jobs.dto.JobsRequest;
import com.example.minijobs.infrastructure.api.jobs.mapper.JobsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class JobsController {

    private final FindJobs findJobs;

    private final JobsMapper jobsMapper;

    @PostMapping("/find")
    public List<Job> findJobs(@RequestBody JobsRequest request, @RequestHeader("api-key") String apiKey) throws NoCreditsException, UnknownUserException {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new UnknownUserException("API Key is required");
        }
        return this.findJobs.find(apiKey, this.jobsMapper.toJobQueryData(request), request.getPageNumber(), request.getPageSize());
    }
    

}
