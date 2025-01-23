package com.cortestudios.cliconverter.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestModel {
    private String sourceFormat;
    private String destinationFormat;
    private String object;
}
