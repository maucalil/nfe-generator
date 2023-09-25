package com.mauricio.domain.rpsSP;

import com.mauricio.domain.enums.TipoRegistro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoteRpsTxt {
    private Cabecalho cabecalho;
    private List<RpsTxt> rpsList;

    public static LoteRpsTxt fromTxtFile(String filePath) throws IOException {
        LoteRpsTxt lote = new LoteRpsTxt();
        lote.rpsList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                int codigo = Integer.parseInt(line.substring(0, 1));

                if (codigo == TipoRegistro.CABECALHO.getCodigo()) {
                    Cabecalho cabecalho = Cabecalho.fromString(line);
                    System.out.println(cabecalho);
                } else if (codigo == TipoRegistro.DETALHE.getCodigo()) {
                    RpsTxt rps = RpsTxt.fromString(line);
                    System.out.println(rps);
                    lote.rpsList.add(rps);
                } else if (codigo == TipoRegistro.RODAPE.getCodigo()) {
                    Rodape rodape = Rodape.fromString(line);
                    System.out.println(rodape);
                }
            }
        } catch (IOException e) {
            throw e;
        }

        return lote;
    }
}
