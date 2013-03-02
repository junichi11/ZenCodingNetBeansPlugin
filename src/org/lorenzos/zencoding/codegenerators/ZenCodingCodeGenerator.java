
package org.lorenzos.zencoding.codegenerators;

import io.emmet.Emmet;
import java.util.Collections;
import java.util.List;
import javax.swing.text.JTextComponent;
import org.lorenzos.utils.*;
import org.lorenzos.zencoding.zeneditor.ZenEditor;
import org.netbeans.spi.editor.codegen.CodeGenerator;
import org.openide.util.Lookup;

public class ZenCodingCodeGenerator implements CodeGenerator {

	private JTextComponent textComp;

	private ZenCodingCodeGenerator(Lookup context) {
		textComp = context.lookup(JTextComponent.class);
	}

	public static class Factory implements CodeGenerator.Factory {
		@Override
		public List<? extends CodeGenerator> create(Lookup context) {
			return Collections.singletonList(new ZenCodingCodeGenerator(context));
		}
	}

	@Override
	public String getDisplayName() {
		return "Expand Emmet abbreviation";
	}

	@Override
	public void invoke() {
		try {
			Emmet emmet = Emmet.getSingleton();
			ZenEditor editor = ZenEditor.create(textComp);
			emmet.runAction(editor, "expand_abbreviation");
			editor.restoreInitialScrollingPosition();
		} catch (Exception ex) {
			ex.printStackTrace(OutputUtils.getErrorStream());
		}
	}
}
