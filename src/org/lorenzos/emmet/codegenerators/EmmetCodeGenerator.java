
package org.lorenzos.emmet.codegenerators;

import io.emmet.Emmet;
import java.util.Collections;
import java.util.List;
import javax.swing.text.JTextComponent;
import org.lorenzos.utils.*;
import org.lorenzos.emmet.editor.EmmetEditor;
import org.netbeans.spi.editor.codegen.CodeGenerator;
import org.openide.util.Lookup;

public class EmmetCodeGenerator implements CodeGenerator {

	private JTextComponent textComp;

	private EmmetCodeGenerator(Lookup context) {
		textComp = context.lookup(JTextComponent.class);
	}

	public static class Factory implements CodeGenerator.Factory {
		@Override
		public List<? extends CodeGenerator> create(Lookup context) {
			return Collections.singletonList(new EmmetCodeGenerator(context));
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
			EmmetEditor editor = EmmetEditor.create(textComp);
			emmet.runAction(editor, "expand_abbreviation");
			editor.restoreInitialScrollingPosition();
		} catch (Exception ex) {
			ex.printStackTrace(OutputUtils.getErrorStream());
		}
	}
}
