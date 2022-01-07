package omega.instant.support.python.assist;
import omega.Screen;

import omega.instant.support.java.assist.DataMember;
import omega.instant.support.java.assist.ContentTokenizer;

import java.util.LinkedList;

import omega.instant.support.java.framework.CodeFramework;

import omega.ui.component.Editor;

import omega.instant.support.AbstractContentTokenizer;
public class PythonContentTokenizer extends AbstractContentTokenizer{
	
	private LinkedList<DataMember> keywords = new LinkedList<>();
	
	public PythonContentTokenizer(){
		add("False", null);
		add("None", null);
		add("True", null);
		add("and", null);
		add("as", null);
		add("assert", null);
		add("async", null);
		add("await", null);
		add("break", null);
		add("class", null);
		add("continue", null);
		add("def", null);
		add("del", null);
		add("elif", null);
		add("else", null);
		add("except", null);
		add("finally", null);
		add("for", null);
		add("from", null);
		add("global", null);
		add("if", null);
		add("import", null);
		add("in", null);
		add("is", null);
		add("lambda", null);
		add("nonlocal", null);
		add("not", null);
		add("or", null);
		add("pass", null);
		add("raise", null);
		add("return", null);
		add("try", null);
		add("while", null);
		add("with", null);
		add("yield", null);
	}
	
	private void add(String keyword, String parameters){
		keywords.add(new DataMember("", "", "keyword", keyword, parameters));
	}
	
	@Override
	public boolean canArrangeTokens(Editor editor) {
		return editor.currentFile != null && editor.currentFile.getName().endsWith(".py");
	}
	
	@Override
	public void arrangeTokens(Editor editor) {
		String match = CodeFramework.getCodeIgnoreDot(editor.getText(), editor.getCaretPosition());
		
		if(!Screen.isNotNull(match)){
			ContentTokenizer.arrangeTokens(editor, match);
			return;
		}
		
		LinkedList<DataMember> hints = new LinkedList<>();
		keywords.forEach(keyword->{
			if(keyword.name.contains(match))
				hints.add(keyword);
		});
		
		if(!hints.isEmpty())
			CodeFramework.gen(hints, editor);
		else
			ContentTokenizer.arrangeTokens(editor, match);
	}
}
