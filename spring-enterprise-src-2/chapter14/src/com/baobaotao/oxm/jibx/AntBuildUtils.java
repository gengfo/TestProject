package com.baobaotao.oxm.jibx;

import java.io.File;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;

public class AntBuildUtils {
	public static void doBuild(String buildFilePath) {
		File buildFile = new File(buildFilePath);
		// ����һ��ANT��Ŀ
		Project p = new Project();
		try {
			p.fireBuildStarted();
			// ��ʼ������Ŀ
			p.init();
			ProjectHelper helper = ProjectHelper.getProjectHelper();
			// ������Ŀ�Ĺ����ļ�
			helper.parse(p, buildFile);
			// ִ����Ŀ��ĳһ��Ŀ��
			p.executeTarget(p.getDefaultTarget());
			p.fireBuildFinished(null);
		} catch (BuildException e) {
			e.printStackTrace();
		}
	}

}
