/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.validation;

/**
 *
 * @author gusta
 */
public class VeiculoValidation {

    public static void validar(
            String placa,
            String marca,
            String modelo,
            int anoFabricacao,
            int anoModelo
    ) throws Exception {

        GenericValidation.obrigatorio(placa, "Placa");
        validarPlacaMercosul(placa);

        GenericValidation.obrigatorio(marca, "Marca");
        GenericValidation.tamanhoMinimo(marca, "Marca", 2);
        GenericValidation.tamanhoMaximo(marca, "Marca", 50);

        GenericValidation.obrigatorio(modelo, "Modelo");
        GenericValidation.tamanhoMinimo(modelo, "Modelo", 2);
        GenericValidation.tamanhoMaximo(modelo, "Modelo", 50);

        GenericValidation.valorMinimo(
                anoFabricacao,
                "Ano de Fabricação",
                1900
        );

        GenericValidation.valorMinimo(
                anoModelo,
                "Ano do Modelo",
                1900
        );

        if (anoModelo < anoFabricacao) {
            throw new Exception(
                    "Ano do Modelo não pode ser menor que o Ano de Fabricação."
            );
        }
    }

    public static void validarPlacaMercosul(String placa)
            throws Exception {

        if (placa == null || placa.trim().isEmpty()) {
            throw new Exception("Placa é obrigatória.");
        }

        String placaFormatada = placa
                .toUpperCase()
                .trim()
                .replaceAll("[^A-Z0-9]", "");

        if (!placaFormatada.matches("[A-Z]{3}[0-9][A-Z][0-9]{2}")) {
            throw new Exception(
                    "Placa inválida. Formato esperado: ABC1D23."
            );
        }
    }
}


