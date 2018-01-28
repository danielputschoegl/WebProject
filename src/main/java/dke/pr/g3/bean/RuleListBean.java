package dke.pr.g3.bean;

import dke.pr.cli.Flora2Interface;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.io.IOException;
import java.util.List;

//Funktioniert nicht weil die RuleList immer null ist

@ManagedBean(name = "ruleList", eager = true)
@ViewScoped
public class RuleListBean {
    private Flora2Interface flora = new Flora2Interface();
    private String rules;
    private String ruleName;
    private List<String> ruleList;


    public boolean delete(String rule, String ruleId) {
        try {
            flora.init();
            flora.delRule(rule, ruleId);
            this.rules = flora.getRules();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    public void addRule(String ctx) throws IOException {
        String path = "C:/Flora-2/CBRM/Contexts/";

        flora.init();
        try {
            flora.addRule(ctx, this.ruleName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.rules = this.getRules();
        this.ruleName = null;
    }

    public List<String> getRulesAsList() throws Exception {
        List<String> rules;
        List<String> ctxs = flora.getCtxs();
        for (String ctx : ctxs) {
            rules = flora.getRulesAsList(ctx);
            ruleList.addAll(rules);
        }
        return ruleList;
    }

    public String getRules() {
        if (this.rules == null) {
            try {
                this.rules = flora.getRules();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return rules;
    }

    public String getRuleName() {
        return ruleName;
    }
}
