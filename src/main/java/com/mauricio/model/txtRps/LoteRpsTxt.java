package com.mauricio.model.txtRps;

import com.mauricio.model.enums.TipoRegistroEnum;

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
                if (line.startsWith(TipoRegistroEnum.CABECALHO.getCodigo())) {
                    Cabecalho cabecalho = Cabecalho.fromString(line);
                    System.out.println(cabecalho);
                } else if (line.startsWith(TipoRegistroEnum.DETALHE.getCodigo())) {
                    RpsTxt rps = new RpsTxt();
                    lote.rpsList.add(rps);
                } else if (line.startsWith(TipoRegistroEnum.RODAPE.getCodigo())) {
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
