package com.rcc.brew.search;

import com.rcc.brew.bean.Yeast;
import com.rcc.brew.bean.Mfg;

import com.rcc.search.AbstractIdentifiableDocumentFactory;
import com.rcc.search.Utils;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;

public class YeastDocumentFactory extends AbstractIdentifiableDocumentFactory<Yeast> {
    protected void finishDocument(Document doc, Yeast y) {
        StringBuilder buf = new StringBuilder();

        if (y.hasName()) {
            Utils.addField(doc, y, "name", Field.Store.YES, Field.Index.TOKENIZED, buf, null);
        }

        if (y.hasMfg()) {
            if (y.getMfg().hasName()) {
                Utils.addField(doc, y, "mfg.name", Field.Store.YES, Field.Index.TOKENIZED,
                        buf, " ");
            }
        }

        doc.add(new Field("all", buf.toString(), Field.Store.NO, Field.Index.TOKENIZED));
    }

    protected Yeast getObject(Document doc, int id) {
        Yeast y = new Yeast();
        y.setId(id);

        Utils.setStringProperty(doc, y, "name");

        if (doc.getField("mfg.name") != null) {
            if (!y.hasMfg()) { y.setMfg(new Mfg()); }
            Utils.setStringProperty(doc, y, "mfg.name");
        }

        return y;
    }
}
