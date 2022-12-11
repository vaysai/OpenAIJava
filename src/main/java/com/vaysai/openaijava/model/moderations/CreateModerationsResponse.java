package com.vaysai.openaijava.model.moderations;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModerationsResponse {
    private String d;
    private String model;
    private Results results;
    // private List<> Pendiente
}
