package com.mauricio.domain.utils;

public class MunicipioUtil {
    public static Integer getCodigoMunicipio(String municipio) {
        if (municipio.equalsIgnoreCase("SERTAOZINHO"))
            return ConstantUtils.CODIGO_SERTAOZINHO_IBGE;

        return ConstantUtils.CODIGO_PONTAL_IBGE;
    }
}
