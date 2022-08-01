package com.sikejava.framework.maven.info.extension;

import org.apache.maven.AbstractMavenLifecycleParticipant;
import org.apache.maven.MavenExecutionException;
import org.apache.maven.execution.MavenSession;
import org.codehaus.plexus.component.annotations.Component;

import java.util.Objects;

/**
 * 打印一些信息的扩展
 *
 * @author skjv2014@163.com
 * @date 2022-07-20 00:59:45
 */
@Component(role = AbstractMavenLifecycleParticipant.class)
public class InfoMavenLifecycleParticipant extends AbstractMavenLifecycleParticipant {

    private static final String PROPERTY_FOR_SKIP = "sk.maven.info.skip";

    @Override
    public void afterProjectsRead(MavenSession session) throws MavenExecutionException {
        if (shouldSkip(session)) {
            return;
        }

        System.out.println("[INFO]");
        System.out.println("[INFO] 有问题, 请微信联系我: we366266");
        System.out.println("[INFO]");
    }

    /**
     * 是否应该跳过
     */
    private boolean shouldSkip(MavenSession session) {
        String skipValueStr = session.getCurrentProject().getProperties().getProperty(PROPERTY_FOR_SKIP);
        return Objects.equals("true", skipValueStr);
    }
}
