package com.rcc.brew.search;

import com.rcc.brew.bean.Adjunct;
import com.rcc.brew.bean.Mfg;

import com.rcc.search.AbstractIdentifiableDocumentFactory;
import com.rcc.search.Utils;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;

public class AdjunctDocumentFactory extends AbstractIdentifiableDocumentFactory<Adjunct> {
    protected void finishDocument(Document doc, Adjunct a) {
        StringBuilder buf = new StringBuilder();

        if (a.hasName()) {
            Utils.addField(doc, a, "name", Field.Store.YES, Field.Index.TOKENIZED, buf, null);
        }

        if (a.hasMfg()) {
            if (a.getMfg().hasName()) {
                Utils.addField(doc, a, "mfg.name", Field.Store.YES, Field.Index.TOKENIZED,
                        buf, " ");
            }
        }

        doc.add(new Field("all", buf.toString(), Field.Store.NO, Field.Index.TOKENIZED));
    }

    protected Adjunct getObject(Document doc, int id) {
        Adjunct a = new Adjunct();
        a.setId(id);

        Utils.setStringProperty(doc, a, "name");

        if (doc.getField("mfg.name") != null) {
            if (!a.hasMfg()) { a.setMfg(new Mfg()); }
            Utils.setStringProperty(doc, a, "mfg.name");
        }

        return a;
    }
}
