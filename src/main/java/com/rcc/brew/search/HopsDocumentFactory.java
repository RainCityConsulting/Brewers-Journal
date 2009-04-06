package com.rcc.brew.search;

import com.rcc.brew.bean.Hops;
import com.rcc.brew.bean.Mfg;

import com.rcc.search.AbstractIdentifiableDocumentFactory;
import com.rcc.search.Utils;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;

public class HopsDocumentFactory extends AbstractIdentifiableDocumentFactory<Hops> {
    protected void finishDocument(Document doc, Hops hops) {
        StringBuilder buf = new StringBuilder();

        if (hops.hasName()) {
            Utils.addField(doc, hops, "name", Field.Store.YES, Field.Index.TOKENIZED, buf, null);
        }

        if (hops.hasMfg()) {
            if (hops.getMfg().hasName()) {
                Utils.addField(doc, hops, "mfg.name", Field.Store.YES, Field.Index.TOKENIZED,
                        buf, " ");
            }
        }

        doc.add(new Field("all", buf.toString(), Field.Store.NO, Field.Index.TOKENIZED));
    }

    protected Hops getObject(Document doc, int id) {
        Hops hops = new Hops();
        hops.setId(id);

        Utils.setStringProperty(doc, hops, "name");

        if (doc.getField("mfg.name") != null) {
            if (!hops.hasMfg()) { hops.setMfg(new Mfg()); }
            Utils.setStringProperty(doc, hops, "mfg.name");
        }

        return hops;
    }
}
