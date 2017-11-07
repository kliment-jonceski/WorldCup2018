package code.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Created by kliment on 10/30/2017.
 */

public class TestGenerator {
    private static final String INJECTION_DIRECTORY  = "injection";
    private static final String INTERACTOR_DIRECTORY  = "interactor";
    private static final String PRESENTER_DIRECTORY  = "presenter";
    private static final String ROUTER_DIRECTORY  = "router";
    private static final String VIEW_DIRECTORY  = "view";

    private static final String FEATURE_PREFIX = "NewsDetails";
    private static final String INTERACTOR_SUFIX = "Interactor";

    private static final String PACKAGE_NAME  = "jonceski.kliment.worldcup2018.ui.features.news_details_feature";

    private String className = "";
    public TestGenerator() {
        className = FEATURE_PREFIX + INTERACTOR_SUFIX;
    }

    public void generateTest() {
        String pathToFeature = getSourceCodePath();
        createViperDirsAndSourceClass(pathToFeature);
    }

    private String getSourceCodePath() {
        String path = "";
        try {
            String packageNameNews = PACKAGE_NAME;
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            packageNameNews = packageNameNews.replace(".", "/");
            URL packageURL = classLoader.getResource(packageNameNews);

            URI uri = new URI(packageURL.toString());
            String pathRes = uri.toString();
            path = pathRes.replace("build/intermediates/classes/debug/", "src/main/java/");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (path.startsWith("file:/")) {
            path = path.replace("file:/", "");
        }
        return  path;
    }

    private void createViperDirsAndSourceClass(String path) {
        createDirAndSourceInjection(path + "/" + INJECTION_DIRECTORY);
        createDirAndSourceInteractor(path + "/" + INTERACTOR_DIRECTORY);
        createDirAndSourcePresenter(path + "/" + PRESENTER_DIRECTORY);
        createDirAndSourceRouter(path + "/" + ROUTER_DIRECTORY);
        createDirAndSourceView(path + "/" + VIEW_DIRECTORY);
    }

    private void createDirAndSourceInjection(String file) {
        createDir(file);
    }

    private void createDirAndSourceInteractor(String file) {
        if (createDir(file)) {
            createInteractorSourceClass(file);
        }
    }

    private void createDirAndSourcePresenter(String file) {
        createDir(file);
    }

    private void createDirAndSourceRouter(String file) {
        createDir(file);
    }

    private void createDirAndSourceView(String file) {
        createDir(file);
    }

    private boolean createDir(String dirName) {
        File directory = new File(dirName);
        if (! directory.exists()) {
            return directory.mkdir();
        }

        return false;
    }

    private void createInteractorSourceClass(String fileDir) {

        StringBuilder sourceBuilder = new StringBuilder();
        sourceBuilder.append("package " + PACKAGE_NAME + "." + INTERACTOR_DIRECTORY + ";\n\n");
        sourceBuilder.append("import java.util.*;\n\n");
        sourceBuilder.append("public class " + className + " {\n");
        sourceBuilder.append("\tpublic " + className +" () {\n");
        sourceBuilder.append("\t}\n");
        sourceBuilder.append("}");

        File file = new File(fileDir + "/" + className + ".java");
        try{
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(sourceBuilder.toString());
            bw.close();
        }
        catch (IOException e){
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
