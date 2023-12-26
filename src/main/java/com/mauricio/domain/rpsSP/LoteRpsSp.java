package com.mauricio.domain.rpsSP;

import com.mauricio.domain.enums.TipoRegistro;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class LoteRpsSp {
    private Cabecalho cabecalho;
    private List<RpsSp> rpsList;
    private Rodape rodape;

    public static LoteRpsSp fromTxtFile(String filePath) throws IOException {
        LoteRpsSp lote = new LoteRpsSp();
        lote.rpsList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                int codigo = Integer.parseInt(line.substring(0, 1));

                if (codigo == TipoRegistro.CABECALHO.getCodigo()) {
                    Cabecalho cabecalho = Cabecalho.fromString(line);
                    lote.setCabecalho(cabecalho);
                } else if (codigo == TipoRegistro.DETALHE.getCodigo()) {
                    RpsSp rps = RpsSp.fromString(line);
                    lote.rpsList.add(rps);
                } else if (codigo == TipoRegistro.RODAPE.getCodigo()) {
                    Rodape rodape = Rodape.fromString(line);
                    lote.setRodape(rodape);
                }
            }
        } catch (NumberFormatException e) {
            throw new IOException();
        }

        return lote;
    }
}
