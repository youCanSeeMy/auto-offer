package zy.util.param;

import lombok.Data;

/**
 * @program: auto-offer
 * @description: 自动生成代码参数
 * @author: 张钰
 * @create: 2020-08-27 17:33
 **/
@Data
public class GeneratorParam {
    private String projectPath = "D:\\code\\auto-offer";
    /**
     * 输出路径
     */
    private String outPutPath = projectPath+"\\src\\main\\java";
    /**
     * 作者
     */
    private String author = "zy";
    /**
     * 数据库路径
     */
    private String dataSourceUrl = "jdbc:mysql://localhost:3306/vue_shop?useSSL=false&serverTimezone=UTC";

    private String dataSourceUserName = "root";

    private String dataSourcePassword = "123456";

    private String modularPath = "zy";

    private String modularName = "user";

    private String templatePath = "";


    public String getOutPutPath() {
        return outPutPath;
    }

    public void setOutPutPath(String outPutPath) {
        this.outPutPath = outPutPath;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDataSourceUrl() {
        return dataSourceUrl;
    }

    public void setDataSourceUrl(String dataSourceUrl) {
        this.dataSourceUrl = dataSourceUrl;
    }

    public String getDataSourceUserName() {
        return dataSourceUserName;
    }

    public void setDataSourceUserName(String dataSourceUserName) {
        this.dataSourceUserName = dataSourceUserName;
    }

    public String getDataSourcePassword() {
        return dataSourcePassword;
    }

    public void setDataSourcePassword(String dataSourcePassword) {
        this.dataSourcePassword = dataSourcePassword;
    }

    public String getModularPath() {
        return modularPath;
    }

    public void setModularPath(String modularPath) {
        this.modularPath = modularPath;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    public String getModularName() {
        return modularName;
    }

    public void setModularName(String modularName) {
        this.modularName = modularName;
    }
}
