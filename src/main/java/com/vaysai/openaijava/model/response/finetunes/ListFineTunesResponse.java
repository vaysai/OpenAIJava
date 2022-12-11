package com.vaysai.openaijava.model.response.finetunes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListFineTunesResponse {
    private String object;
    private List<Object> data;//Pendiente el tipo
}
