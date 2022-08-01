package com.sikejava.framework.maven.notice.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * 打印一些注意的插件
 *
 * @author skjv2014@163.com
 * @date 2022-07-20 00:37:36
 */
@Mojo(
        name = "notice",
        defaultPhase = LifecyclePhase.PRE_CLEAN,
        threadSafe = true
)
public class NoticeMojo extends AbstractMojo {

    @Parameter(property = "sk.maven.notice.skip", defaultValue = "false")
    private boolean skip;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        if (this.skip) {
            return;
        }

        this.getLog().info("我的github地址: https://github.com/skjv2014");
    }
}
