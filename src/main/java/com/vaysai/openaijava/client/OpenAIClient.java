package com.vaysai.openaijava.client;

import com.vaysai.openaijava.model.completions.CompletionRequest;
import com.vaysai.openaijava.model.edits.EditsRequest;
import com.vaysai.openaijava.model.embeddings.CreateEmbeddingsRequest;
import com.vaysai.openaijava.model.files.UploadFileRequest;
import com.vaysai.openaijava.model.finetunes.*;
import com.vaysai.openaijava.model.images.CreateImageEditsRequest;
import com.vaysai.openaijava.model.images.CreateImageRequest;
import com.vaysai.openaijava.model.images.CreateImageVariationsRequest;
import com.vaysai.openaijava.model.moderations.CreateModerationsRequest;
import com.vaysai.openaijava.model.completions.CompletionResponse;
import com.vaysai.openaijava.model.edits.EditsResponse;
import com.vaysai.openaijava.model.embeddings.CreateEmbeddingsResponse;
import com.vaysai.openaijava.model.files.DeleteFileResponse;
import com.vaysai.openaijava.model.files.ListFilesResponse;
import com.vaysai.openaijava.model.files.RetrieveFileResponse;
import com.vaysai.openaijava.model.files.UploadFilesResponse;
import com.vaysai.openaijava.model.images.CreateImageEditsResponse;
import com.vaysai.openaijava.model.images.CreateImageResponse;
import com.vaysai.openaijava.model.images.CreateImageVariationsResponse;
import com.vaysai.openaijava.model.models.ListModelsResponse;
import com.vaysai.openaijava.model.models.RetrieveModelResponse;
import com.vaysai.openaijava.model.moderations.CreateModerationsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "openAIApi", url = "${openAIApi.url}")
public interface OpenAIClient {

    //Models

    @GetMapping(value = "/models", consumes = "application/json")
    ListModelsResponse listModels();

    @GetMapping(value = "/models/{model}", consumes = "application/json")
    RetrieveModelResponse retrieveModel(@PathVariable("model") String model);


    //Completions

    @PostMapping(value = "/completions", consumes = "application/json")
    CompletionResponse createCompletion(CompletionRequest completionRequest);

    //Edits

    @PostMapping(value="/edits", consumes = "application/json")
    EditsResponse createEdit(EditsRequest editsRequest);

    //Images

    @PostMapping(value="/images/generations",consumes = "application/json")
    CreateImageResponse createImageGenerations(CreateImageRequest createImageReques);

    @PostMapping(value="/images/edits",consumes = "application/json")
    CreateImageEditsResponse createImageEdits(CreateImageEditsRequest createImageEditsRequest);

    @PostMapping(value="/images/variations",consumes = "application/json")
    CreateImageVariationsResponse createdImageVariations(CreateImageVariationsRequest createdImageVariationsRequest);


    //Embeddings

    @PostMapping(value="/embeddings",consumes = "application/json")
    CreateEmbeddingsResponse createEmbeddings(CreateEmbeddingsRequest createEmbeddingsRequest);

    @GetMapping(value="/files", consumes = "application/json")
    ListFilesResponse listFiles();

    @PostMapping(value="/files", consumes = "application/json")
    UploadFilesResponse uploadFile(UploadFileRequest uploadFileRequest);

    @DeleteMapping(value="/files/{file_id}", consumes = "application/json")
    DeleteFileResponse deleteFile(@PathVariable("file_id") String fileId);

    @GetMapping(value="/files/{file_id}", consumes = "application/json")
    RetrieveFileResponse retrieveFile(@PathVariable("file_id") String fileId);

    @GetMapping(value="/files/{file_id}/content}", consumes="application/json")
    ResponseEntity<?> retrieveFileContent(@PathVariable("file_id") String fileId);

    @PostMapping(value="/fine-tunes", consumes="application/json")
    CreateFineTuneResponse createFileTune(CreateFineTuneRequest createFileTuneRequest);

    @GetMapping(value="/fine-tunes", consumes="application/json")
    ListFineTuneResponse listFineTunes();

    @GetMapping(value="/fine-tunes/{fine_tune_id}", consumes = "application/json")
    RetrieveFineTuneResponse retrieveFineTune(@PathVariable("fine_tune_id") String fineTuneId);

    @PostMapping(value="/fine-tunes/{fine_tune_id}/cancel")
    CancelFineTuneResponse cancelFineTune(@PathVariable("fine_tune_id") String fineTuneId);

    @GetMapping(value="/fine-tunes/{fine_tune_id}/events", consumes = "application/json")
    ListFineTuneEventsResponse listFineTunes(@PathVariable("fine_tune_id") String fineTuneId);

    @DeleteMapping(value="/models/{model}", consumes = "application/json")
    DeleteFineTuneModelResponse deleteFineTuneModel(@PathVariable("model") String model);


    @PostMapping(value="/moderations",consumes = "application/json")
    CreateModerationsResponse createModerations(CreateModerationsRequest createModerationsRequest);

    @PostMapping(value="/fine-tunes",consumes = "application/json")
    CreateFineTuneResponse createFineTunes(CreateFineTuneRequest createFineTuneRequest);

}