package omega.instant.support.python.assist;
import java.net.URL;

import omega.instant.support.ContentTokenizers;

import omega.plugin.Plugin;
import omega.plugin.PluginCategory;
public class PythonAssistPlugin implements Plugin{
	private PythonContentTokenizer pythonContentTokenizer;
	@Override
	public boolean init() {
		pythonContentTokenizer = new PythonContentTokenizer();
		return true;
	}
	
	@Override
	public boolean enable() {
		ContentTokenizers.add(pythonContentTokenizer);
		return true;
	}
	
	@Override
	public boolean disable() {
		ContentTokenizers.contentTokenizers.remove(pythonContentTokenizer);
		return true;
	}

	@Override
	public URL getImage() {
		try{
			return getClass().getResource("/fluent-icons/icons8-python-48.png");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String getName() {
		return "Python Basic Assist";
	}
	@Override
	public String getVersion() {
		return "v2.2";
	}
	@Override
	public String getPluginCategory() {
		return PluginCategory.EDITING;
	}
	@Override
	public String getDescription() {
		return "Gives Python Keywords as suggestions.";
	}
	@Override
	public String getAuthor() {
		return "Omega UI";
	}
	@Override
	public String getLicense() {
		return "GNU GPL v3";
	}
	@Override
	public boolean needsRestart() {
		return false;
	}
	@Override
	public String getSizeInMegaBytes() {
		return "0.01 MB";
	}
	
}
