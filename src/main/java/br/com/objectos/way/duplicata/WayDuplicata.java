/*
 * WayDuplicata.java criado em 06/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

import java.io.File;
import java.io.IOException;

import com.google.inject.ImplementedBy;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@ImplementedBy(WayDuplicataGuice.class)
public interface WayDuplicata {

  interface HtmlOf {

    HtmlOf inlineCss();

    HtmlOf page();

    File toFile(File saida) throws IOException;

    @Override
    String toString();

  }

  HtmlOf htmlOf(Duplicata duplicata);

}