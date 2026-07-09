/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av_car_auto_center.validation;

/**
 *
 * @author gusta
 */
public class ClienteValidation {
    
    public static void validar(String tipoCliente, String nomeRazaoSocial, String cpfCnpj, String telefone, String email) throws Exception {
 
        GenericValidation.obrigatorio(tipoCliente, "Tipo de Cliente");
        GenericValidation.valoresPermitidos(tipoCliente, "Tipo de Cliente", "Físico", "Jurídico");
 
        GenericValidation.obrigatorio(nomeRazaoSocial, "Nome / Razão Social");
        GenericValidation.tamanhoMinimo(nomeRazaoSocial, "Nome / Razão Social", 3);
        GenericValidation.tamanhoMaximo(nomeRazaoSocial, "Nome / Razão Social", 100);
 
        GenericValidation.obrigatorio(cpfCnpj, "CPF/CNPJ");
        
        String numeros = cpfCnpj.replaceAll("[^0-9]", "");

        if (numeros.length() != 11 && numeros.length() != 14) {
            throw new Exception("CPF/CNPJ deve conter 11 ou 14 dígitos.");
        }
 
        GenericValidation.digitosEntre(telefone, "Telefone", 10, 11);
 
        GenericValidation.formatoEmail(email, "Email");
        GenericValidation.tamanhoMaximo(email, "Email", 150);
    }
}
