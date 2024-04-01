package br.com.alura.screensound.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.modelmapper.ModelMapper;

public class GenericConverter {

    private final ModelMapper modelMapper;

    public GenericConverter() {
        this.modelMapper = new ModelMapper();
    }

    public <S, T> T convert(S source, Class<T> targetClass) {
        return modelMapper.map(source, targetClass);
    }
}