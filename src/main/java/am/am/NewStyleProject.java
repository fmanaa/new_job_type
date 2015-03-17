
package am.am;

import hudson.Extension;
import hudson.model.ItemGroup;
import hudson.model.TopLevelItem;
import hudson.model.Project;
import jenkins.model.Jenkins;

import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;

public class NewStyleProject extends Project<NewStyleProject,NewStyleBuild> implements TopLevelItem {

    public NewStyleProject(ItemGroup parent, String name) {
        super(parent, name);
    }

    @Override
    protected Class<NewStyleBuild> getBuildClass() {
        return NewStyleBuild.class;
    }

    public DescriptorImpl getDescriptor() {
        return (DescriptorImpl)Jenkins.getInstance().getDescriptorOrDie(getClass());
    }

    @Restricted(NoExternalUse.class)
    @Extension(ordinal=1000)
    public static final DescriptorImpl DESCRIPTOR = new DescriptorImpl();

    public static final class DescriptorImpl extends AbstractProjectDescriptor {
        public String getDisplayName() {
            return "New Style Project";
        }

        public NewStyleProject newInstance(ItemGroup parent, String name) {
            return new NewStyleProject(parent,name);
        }
    }
}
