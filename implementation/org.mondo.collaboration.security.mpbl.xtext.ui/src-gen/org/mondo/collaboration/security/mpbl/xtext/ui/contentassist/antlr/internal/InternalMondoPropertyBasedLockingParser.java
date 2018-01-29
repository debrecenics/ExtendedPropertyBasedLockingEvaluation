package org.mondo.collaboration.security.mpbl.xtext.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.mondo.collaboration.security.mpbl.xtext.services.MondoPropertyBasedLockingGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMondoPropertyBasedLockingParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'locks'", "'{'", "'}'", "'user'", "'group'", "','", "'lock'", "'query'", "'bind'", "'role'", "'value'", "'object'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalMondoPropertyBasedLockingParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMondoPropertyBasedLockingParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMondoPropertyBasedLockingParser.tokenNames; }
    public String getGrammarFileName() { return "../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g"; }


     
     	private MondoPropertyBasedLockingGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(MondoPropertyBasedLockingGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRulePropertyBasedLockingModel"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:60:1: entryRulePropertyBasedLockingModel : rulePropertyBasedLockingModel EOF ;
    public final void entryRulePropertyBasedLockingModel() throws RecognitionException {
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:61:1: ( rulePropertyBasedLockingModel EOF )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:62:1: rulePropertyBasedLockingModel EOF
            {
             before(grammarAccess.getPropertyBasedLockingModelRule()); 
            pushFollow(FOLLOW_rulePropertyBasedLockingModel_in_entryRulePropertyBasedLockingModel61);
            rulePropertyBasedLockingModel();

            state._fsp--;

             after(grammarAccess.getPropertyBasedLockingModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyBasedLockingModel68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePropertyBasedLockingModel"


    // $ANTLR start "rulePropertyBasedLockingModel"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:69:1: rulePropertyBasedLockingModel : ( ( rule__PropertyBasedLockingModel__Group__0 ) ) ;
    public final void rulePropertyBasedLockingModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:73:2: ( ( ( rule__PropertyBasedLockingModel__Group__0 ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:74:1: ( ( rule__PropertyBasedLockingModel__Group__0 ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:74:1: ( ( rule__PropertyBasedLockingModel__Group__0 ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:75:1: ( rule__PropertyBasedLockingModel__Group__0 )
            {
             before(grammarAccess.getPropertyBasedLockingModelAccess().getGroup()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:76:1: ( rule__PropertyBasedLockingModel__Group__0 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:76:2: rule__PropertyBasedLockingModel__Group__0
            {
            pushFollow(FOLLOW_rule__PropertyBasedLockingModel__Group__0_in_rulePropertyBasedLockingModel94);
            rule__PropertyBasedLockingModel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPropertyBasedLockingModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePropertyBasedLockingModel"


    // $ANTLR start "entryRuleRole"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:88:1: entryRuleRole : ruleRole EOF ;
    public final void entryRuleRole() throws RecognitionException {
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:89:1: ( ruleRole EOF )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:90:1: ruleRole EOF
            {
             before(grammarAccess.getRoleRule()); 
            pushFollow(FOLLOW_ruleRole_in_entryRuleRole121);
            ruleRole();

            state._fsp--;

             after(grammarAccess.getRoleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRole128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRole"


    // $ANTLR start "ruleRole"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:97:1: ruleRole : ( ( rule__Role__Alternatives ) ) ;
    public final void ruleRole() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:101:2: ( ( ( rule__Role__Alternatives ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:102:1: ( ( rule__Role__Alternatives ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:102:1: ( ( rule__Role__Alternatives ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:103:1: ( rule__Role__Alternatives )
            {
             before(grammarAccess.getRoleAccess().getAlternatives()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:104:1: ( rule__Role__Alternatives )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:104:2: rule__Role__Alternatives
            {
            pushFollow(FOLLOW_rule__Role__Alternatives_in_ruleRole154);
            rule__Role__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getRoleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRole"


    // $ANTLR start "entryRuleUser"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:116:1: entryRuleUser : ruleUser EOF ;
    public final void entryRuleUser() throws RecognitionException {
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:117:1: ( ruleUser EOF )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:118:1: ruleUser EOF
            {
             before(grammarAccess.getUserRule()); 
            pushFollow(FOLLOW_ruleUser_in_entryRuleUser181);
            ruleUser();

            state._fsp--;

             after(grammarAccess.getUserRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUser188); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUser"


    // $ANTLR start "ruleUser"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:125:1: ruleUser : ( ( rule__User__Group__0 ) ) ;
    public final void ruleUser() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:129:2: ( ( ( rule__User__Group__0 ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:130:1: ( ( rule__User__Group__0 ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:130:1: ( ( rule__User__Group__0 ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:131:1: ( rule__User__Group__0 )
            {
             before(grammarAccess.getUserAccess().getGroup()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:132:1: ( rule__User__Group__0 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:132:2: rule__User__Group__0
            {
            pushFollow(FOLLOW_rule__User__Group__0_in_ruleUser214);
            rule__User__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUserAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUser"


    // $ANTLR start "entryRuleGroup"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:144:1: entryRuleGroup : ruleGroup EOF ;
    public final void entryRuleGroup() throws RecognitionException {
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:145:1: ( ruleGroup EOF )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:146:1: ruleGroup EOF
            {
             before(grammarAccess.getGroupRule()); 
            pushFollow(FOLLOW_ruleGroup_in_entryRuleGroup241);
            ruleGroup();

            state._fsp--;

             after(grammarAccess.getGroupRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroup248); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGroup"


    // $ANTLR start "ruleGroup"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:153:1: ruleGroup : ( ( rule__Group__Group__0 ) ) ;
    public final void ruleGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:157:2: ( ( ( rule__Group__Group__0 ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:158:1: ( ( rule__Group__Group__0 ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:158:1: ( ( rule__Group__Group__0 ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:159:1: ( rule__Group__Group__0 )
            {
             before(grammarAccess.getGroupAccess().getGroup()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:160:1: ( rule__Group__Group__0 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:160:2: rule__Group__Group__0
            {
            pushFollow(FOLLOW_rule__Group__Group__0_in_ruleGroup274);
            rule__Group__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGroupAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGroup"


    // $ANTLR start "entryRuleLock"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:172:1: entryRuleLock : ruleLock EOF ;
    public final void entryRuleLock() throws RecognitionException {
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:173:1: ( ruleLock EOF )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:174:1: ruleLock EOF
            {
             before(grammarAccess.getLockRule()); 
            pushFollow(FOLLOW_ruleLock_in_entryRuleLock301);
            ruleLock();

            state._fsp--;

             after(grammarAccess.getLockRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLock308); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLock"


    // $ANTLR start "ruleLock"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:181:1: ruleLock : ( ( rule__Lock__Group__0 ) ) ;
    public final void ruleLock() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:185:2: ( ( ( rule__Lock__Group__0 ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:186:1: ( ( rule__Lock__Group__0 ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:186:1: ( ( rule__Lock__Group__0 ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:187:1: ( rule__Lock__Group__0 )
            {
             before(grammarAccess.getLockAccess().getGroup()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:188:1: ( rule__Lock__Group__0 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:188:2: rule__Lock__Group__0
            {
            pushFollow(FOLLOW_rule__Lock__Group__0_in_ruleLock334);
            rule__Lock__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLockAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLock"


    // $ANTLR start "entryRuleBinding"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:200:1: entryRuleBinding : ruleBinding EOF ;
    public final void entryRuleBinding() throws RecognitionException {
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:201:1: ( ruleBinding EOF )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:202:1: ruleBinding EOF
            {
             before(grammarAccess.getBindingRule()); 
            pushFollow(FOLLOW_ruleBinding_in_entryRuleBinding361);
            ruleBinding();

            state._fsp--;

             after(grammarAccess.getBindingRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBinding368); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBinding"


    // $ANTLR start "ruleBinding"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:209:1: ruleBinding : ( ( rule__Binding__Group__0 ) ) ;
    public final void ruleBinding() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:213:2: ( ( ( rule__Binding__Group__0 ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:214:1: ( ( rule__Binding__Group__0 ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:214:1: ( ( rule__Binding__Group__0 ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:215:1: ( rule__Binding__Group__0 )
            {
             before(grammarAccess.getBindingAccess().getGroup()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:216:1: ( rule__Binding__Group__0 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:216:2: rule__Binding__Group__0
            {
            pushFollow(FOLLOW_rule__Binding__Group__0_in_ruleBinding394);
            rule__Binding__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBindingAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBinding"


    // $ANTLR start "entryRuleBind"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:228:1: entryRuleBind : ruleBind EOF ;
    public final void entryRuleBind() throws RecognitionException {
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:229:1: ( ruleBind EOF )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:230:1: ruleBind EOF
            {
             before(grammarAccess.getBindRule()); 
            pushFollow(FOLLOW_ruleBind_in_entryRuleBind421);
            ruleBind();

            state._fsp--;

             after(grammarAccess.getBindRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBind428); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBind"


    // $ANTLR start "ruleBind"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:237:1: ruleBind : ( ( rule__Bind__Alternatives ) ) ;
    public final void ruleBind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:241:2: ( ( ( rule__Bind__Alternatives ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:242:1: ( ( rule__Bind__Alternatives ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:242:1: ( ( rule__Bind__Alternatives ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:243:1: ( rule__Bind__Alternatives )
            {
             before(grammarAccess.getBindAccess().getAlternatives()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:244:1: ( rule__Bind__Alternatives )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:244:2: rule__Bind__Alternatives
            {
            pushFollow(FOLLOW_rule__Bind__Alternatives_in_ruleBind454);
            rule__Bind__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getBindAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBind"


    // $ANTLR start "entryRuleRoleBind"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:256:1: entryRuleRoleBind : ruleRoleBind EOF ;
    public final void entryRuleRoleBind() throws RecognitionException {
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:257:1: ( ruleRoleBind EOF )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:258:1: ruleRoleBind EOF
            {
             before(grammarAccess.getRoleBindRule()); 
            pushFollow(FOLLOW_ruleRoleBind_in_entryRuleRoleBind481);
            ruleRoleBind();

            state._fsp--;

             after(grammarAccess.getRoleBindRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRoleBind488); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRoleBind"


    // $ANTLR start "ruleRoleBind"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:265:1: ruleRoleBind : ( ( rule__RoleBind__Group__0 ) ) ;
    public final void ruleRoleBind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:269:2: ( ( ( rule__RoleBind__Group__0 ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:270:1: ( ( rule__RoleBind__Group__0 ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:270:1: ( ( rule__RoleBind__Group__0 ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:271:1: ( rule__RoleBind__Group__0 )
            {
             before(grammarAccess.getRoleBindAccess().getGroup()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:272:1: ( rule__RoleBind__Group__0 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:272:2: rule__RoleBind__Group__0
            {
            pushFollow(FOLLOW_rule__RoleBind__Group__0_in_ruleRoleBind514);
            rule__RoleBind__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRoleBindAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRoleBind"


    // $ANTLR start "entryRuleValueBind"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:284:1: entryRuleValueBind : ruleValueBind EOF ;
    public final void entryRuleValueBind() throws RecognitionException {
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:285:1: ( ruleValueBind EOF )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:286:1: ruleValueBind EOF
            {
             before(grammarAccess.getValueBindRule()); 
            pushFollow(FOLLOW_ruleValueBind_in_entryRuleValueBind541);
            ruleValueBind();

            state._fsp--;

             after(grammarAccess.getValueBindRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueBind548); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleValueBind"


    // $ANTLR start "ruleValueBind"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:293:1: ruleValueBind : ( ( rule__ValueBind__Group__0 ) ) ;
    public final void ruleValueBind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:297:2: ( ( ( rule__ValueBind__Group__0 ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:298:1: ( ( rule__ValueBind__Group__0 ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:298:1: ( ( rule__ValueBind__Group__0 ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:299:1: ( rule__ValueBind__Group__0 )
            {
             before(grammarAccess.getValueBindAccess().getGroup()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:300:1: ( rule__ValueBind__Group__0 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:300:2: rule__ValueBind__Group__0
            {
            pushFollow(FOLLOW_rule__ValueBind__Group__0_in_ruleValueBind574);
            rule__ValueBind__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getValueBindAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValueBind"


    // $ANTLR start "entryRuleObjectBind"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:312:1: entryRuleObjectBind : ruleObjectBind EOF ;
    public final void entryRuleObjectBind() throws RecognitionException {
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:313:1: ( ruleObjectBind EOF )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:314:1: ruleObjectBind EOF
            {
             before(grammarAccess.getObjectBindRule()); 
            pushFollow(FOLLOW_ruleObjectBind_in_entryRuleObjectBind601);
            ruleObjectBind();

            state._fsp--;

             after(grammarAccess.getObjectBindRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectBind608); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleObjectBind"


    // $ANTLR start "ruleObjectBind"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:321:1: ruleObjectBind : ( ( rule__ObjectBind__Group__0 ) ) ;
    public final void ruleObjectBind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:325:2: ( ( ( rule__ObjectBind__Group__0 ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:326:1: ( ( rule__ObjectBind__Group__0 ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:326:1: ( ( rule__ObjectBind__Group__0 ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:327:1: ( rule__ObjectBind__Group__0 )
            {
             before(grammarAccess.getObjectBindAccess().getGroup()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:328:1: ( rule__ObjectBind__Group__0 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:328:2: rule__ObjectBind__Group__0
            {
            pushFollow(FOLLOW_rule__ObjectBind__Group__0_in_ruleObjectBind634);
            rule__ObjectBind__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getObjectBindAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleObjectBind"


    // $ANTLR start "rule__Role__Alternatives"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:340:1: rule__Role__Alternatives : ( ( ruleUser ) | ( ruleGroup ) );
    public final void rule__Role__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:344:1: ( ( ruleUser ) | ( ruleGroup ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==14) ) {
                alt1=1;
            }
            else if ( (LA1_0==15) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:345:1: ( ruleUser )
                    {
                    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:345:1: ( ruleUser )
                    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:346:1: ruleUser
                    {
                     before(grammarAccess.getRoleAccess().getUserParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleUser_in_rule__Role__Alternatives670);
                    ruleUser();

                    state._fsp--;

                     after(grammarAccess.getRoleAccess().getUserParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:351:6: ( ruleGroup )
                    {
                    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:351:6: ( ruleGroup )
                    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:352:1: ruleGroup
                    {
                     before(grammarAccess.getRoleAccess().getGroupParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleGroup_in_rule__Role__Alternatives687);
                    ruleGroup();

                    state._fsp--;

                     after(grammarAccess.getRoleAccess().getGroupParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Role__Alternatives"


    // $ANTLR start "rule__Bind__Alternatives"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:362:1: rule__Bind__Alternatives : ( ( ruleObjectBind ) | ( ruleValueBind ) | ( ruleRoleBind ) );
    public final void rule__Bind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:366:1: ( ( ruleObjectBind ) | ( ruleValueBind ) | ( ruleRoleBind ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt2=1;
                }
                break;
            case 21:
                {
                alt2=2;
                }
                break;
            case 20:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:367:1: ( ruleObjectBind )
                    {
                    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:367:1: ( ruleObjectBind )
                    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:368:1: ruleObjectBind
                    {
                     before(grammarAccess.getBindAccess().getObjectBindParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleObjectBind_in_rule__Bind__Alternatives719);
                    ruleObjectBind();

                    state._fsp--;

                     after(grammarAccess.getBindAccess().getObjectBindParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:373:6: ( ruleValueBind )
                    {
                    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:373:6: ( ruleValueBind )
                    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:374:1: ruleValueBind
                    {
                     before(grammarAccess.getBindAccess().getValueBindParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleValueBind_in_rule__Bind__Alternatives736);
                    ruleValueBind();

                    state._fsp--;

                     after(grammarAccess.getBindAccess().getValueBindParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:379:6: ( ruleRoleBind )
                    {
                    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:379:6: ( ruleRoleBind )
                    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:380:1: ruleRoleBind
                    {
                     before(grammarAccess.getBindAccess().getRoleBindParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleRoleBind_in_rule__Bind__Alternatives753);
                    ruleRoleBind();

                    state._fsp--;

                     after(grammarAccess.getBindAccess().getRoleBindParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bind__Alternatives"


    // $ANTLR start "rule__PropertyBasedLockingModel__Group__0"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:392:1: rule__PropertyBasedLockingModel__Group__0 : rule__PropertyBasedLockingModel__Group__0__Impl rule__PropertyBasedLockingModel__Group__1 ;
    public final void rule__PropertyBasedLockingModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:396:1: ( rule__PropertyBasedLockingModel__Group__0__Impl rule__PropertyBasedLockingModel__Group__1 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:397:2: rule__PropertyBasedLockingModel__Group__0__Impl rule__PropertyBasedLockingModel__Group__1
            {
            pushFollow(FOLLOW_rule__PropertyBasedLockingModel__Group__0__Impl_in_rule__PropertyBasedLockingModel__Group__0783);
            rule__PropertyBasedLockingModel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyBasedLockingModel__Group__1_in_rule__PropertyBasedLockingModel__Group__0786);
            rule__PropertyBasedLockingModel__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyBasedLockingModel__Group__0"


    // $ANTLR start "rule__PropertyBasedLockingModel__Group__0__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:404:1: rule__PropertyBasedLockingModel__Group__0__Impl : ( () ) ;
    public final void rule__PropertyBasedLockingModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:408:1: ( ( () ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:409:1: ( () )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:409:1: ( () )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:410:1: ()
            {
             before(grammarAccess.getPropertyBasedLockingModelAccess().getPropertyBasedLockingModelAction_0()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:411:1: ()
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:413:1: 
            {
            }

             after(grammarAccess.getPropertyBasedLockingModelAccess().getPropertyBasedLockingModelAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyBasedLockingModel__Group__0__Impl"


    // $ANTLR start "rule__PropertyBasedLockingModel__Group__1"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:423:1: rule__PropertyBasedLockingModel__Group__1 : rule__PropertyBasedLockingModel__Group__1__Impl rule__PropertyBasedLockingModel__Group__2 ;
    public final void rule__PropertyBasedLockingModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:427:1: ( rule__PropertyBasedLockingModel__Group__1__Impl rule__PropertyBasedLockingModel__Group__2 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:428:2: rule__PropertyBasedLockingModel__Group__1__Impl rule__PropertyBasedLockingModel__Group__2
            {
            pushFollow(FOLLOW_rule__PropertyBasedLockingModel__Group__1__Impl_in_rule__PropertyBasedLockingModel__Group__1844);
            rule__PropertyBasedLockingModel__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyBasedLockingModel__Group__2_in_rule__PropertyBasedLockingModel__Group__1847);
            rule__PropertyBasedLockingModel__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyBasedLockingModel__Group__1"


    // $ANTLR start "rule__PropertyBasedLockingModel__Group__1__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:435:1: rule__PropertyBasedLockingModel__Group__1__Impl : ( ( rule__PropertyBasedLockingModel__RolesAssignment_1 )* ) ;
    public final void rule__PropertyBasedLockingModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:439:1: ( ( ( rule__PropertyBasedLockingModel__RolesAssignment_1 )* ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:440:1: ( ( rule__PropertyBasedLockingModel__RolesAssignment_1 )* )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:440:1: ( ( rule__PropertyBasedLockingModel__RolesAssignment_1 )* )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:441:1: ( rule__PropertyBasedLockingModel__RolesAssignment_1 )*
            {
             before(grammarAccess.getPropertyBasedLockingModelAccess().getRolesAssignment_1()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:442:1: ( rule__PropertyBasedLockingModel__RolesAssignment_1 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=14 && LA3_0<=15)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:442:2: rule__PropertyBasedLockingModel__RolesAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__PropertyBasedLockingModel__RolesAssignment_1_in_rule__PropertyBasedLockingModel__Group__1__Impl874);
            	    rule__PropertyBasedLockingModel__RolesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getPropertyBasedLockingModelAccess().getRolesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyBasedLockingModel__Group__1__Impl"


    // $ANTLR start "rule__PropertyBasedLockingModel__Group__2"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:452:1: rule__PropertyBasedLockingModel__Group__2 : rule__PropertyBasedLockingModel__Group__2__Impl rule__PropertyBasedLockingModel__Group__3 ;
    public final void rule__PropertyBasedLockingModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:456:1: ( rule__PropertyBasedLockingModel__Group__2__Impl rule__PropertyBasedLockingModel__Group__3 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:457:2: rule__PropertyBasedLockingModel__Group__2__Impl rule__PropertyBasedLockingModel__Group__3
            {
            pushFollow(FOLLOW_rule__PropertyBasedLockingModel__Group__2__Impl_in_rule__PropertyBasedLockingModel__Group__2905);
            rule__PropertyBasedLockingModel__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyBasedLockingModel__Group__3_in_rule__PropertyBasedLockingModel__Group__2908);
            rule__PropertyBasedLockingModel__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyBasedLockingModel__Group__2"


    // $ANTLR start "rule__PropertyBasedLockingModel__Group__2__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:464:1: rule__PropertyBasedLockingModel__Group__2__Impl : ( 'locks' ) ;
    public final void rule__PropertyBasedLockingModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:468:1: ( ( 'locks' ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:469:1: ( 'locks' )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:469:1: ( 'locks' )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:470:1: 'locks'
            {
             before(grammarAccess.getPropertyBasedLockingModelAccess().getLocksKeyword_2()); 
            match(input,11,FOLLOW_11_in_rule__PropertyBasedLockingModel__Group__2__Impl936); 
             after(grammarAccess.getPropertyBasedLockingModelAccess().getLocksKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyBasedLockingModel__Group__2__Impl"


    // $ANTLR start "rule__PropertyBasedLockingModel__Group__3"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:483:1: rule__PropertyBasedLockingModel__Group__3 : rule__PropertyBasedLockingModel__Group__3__Impl rule__PropertyBasedLockingModel__Group__4 ;
    public final void rule__PropertyBasedLockingModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:487:1: ( rule__PropertyBasedLockingModel__Group__3__Impl rule__PropertyBasedLockingModel__Group__4 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:488:2: rule__PropertyBasedLockingModel__Group__3__Impl rule__PropertyBasedLockingModel__Group__4
            {
            pushFollow(FOLLOW_rule__PropertyBasedLockingModel__Group__3__Impl_in_rule__PropertyBasedLockingModel__Group__3967);
            rule__PropertyBasedLockingModel__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyBasedLockingModel__Group__4_in_rule__PropertyBasedLockingModel__Group__3970);
            rule__PropertyBasedLockingModel__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyBasedLockingModel__Group__3"


    // $ANTLR start "rule__PropertyBasedLockingModel__Group__3__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:495:1: rule__PropertyBasedLockingModel__Group__3__Impl : ( '{' ) ;
    public final void rule__PropertyBasedLockingModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:499:1: ( ( '{' ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:500:1: ( '{' )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:500:1: ( '{' )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:501:1: '{'
            {
             before(grammarAccess.getPropertyBasedLockingModelAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,12,FOLLOW_12_in_rule__PropertyBasedLockingModel__Group__3__Impl998); 
             after(grammarAccess.getPropertyBasedLockingModelAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyBasedLockingModel__Group__3__Impl"


    // $ANTLR start "rule__PropertyBasedLockingModel__Group__4"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:514:1: rule__PropertyBasedLockingModel__Group__4 : rule__PropertyBasedLockingModel__Group__4__Impl rule__PropertyBasedLockingModel__Group__5 ;
    public final void rule__PropertyBasedLockingModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:518:1: ( rule__PropertyBasedLockingModel__Group__4__Impl rule__PropertyBasedLockingModel__Group__5 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:519:2: rule__PropertyBasedLockingModel__Group__4__Impl rule__PropertyBasedLockingModel__Group__5
            {
            pushFollow(FOLLOW_rule__PropertyBasedLockingModel__Group__4__Impl_in_rule__PropertyBasedLockingModel__Group__41029);
            rule__PropertyBasedLockingModel__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PropertyBasedLockingModel__Group__5_in_rule__PropertyBasedLockingModel__Group__41032);
            rule__PropertyBasedLockingModel__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyBasedLockingModel__Group__4"


    // $ANTLR start "rule__PropertyBasedLockingModel__Group__4__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:526:1: rule__PropertyBasedLockingModel__Group__4__Impl : ( ( rule__PropertyBasedLockingModel__LocksAssignment_4 )* ) ;
    public final void rule__PropertyBasedLockingModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:530:1: ( ( ( rule__PropertyBasedLockingModel__LocksAssignment_4 )* ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:531:1: ( ( rule__PropertyBasedLockingModel__LocksAssignment_4 )* )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:531:1: ( ( rule__PropertyBasedLockingModel__LocksAssignment_4 )* )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:532:1: ( rule__PropertyBasedLockingModel__LocksAssignment_4 )*
            {
             before(grammarAccess.getPropertyBasedLockingModelAccess().getLocksAssignment_4()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:533:1: ( rule__PropertyBasedLockingModel__LocksAssignment_4 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:533:2: rule__PropertyBasedLockingModel__LocksAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__PropertyBasedLockingModel__LocksAssignment_4_in_rule__PropertyBasedLockingModel__Group__4__Impl1059);
            	    rule__PropertyBasedLockingModel__LocksAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getPropertyBasedLockingModelAccess().getLocksAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyBasedLockingModel__Group__4__Impl"


    // $ANTLR start "rule__PropertyBasedLockingModel__Group__5"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:543:1: rule__PropertyBasedLockingModel__Group__5 : rule__PropertyBasedLockingModel__Group__5__Impl ;
    public final void rule__PropertyBasedLockingModel__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:547:1: ( rule__PropertyBasedLockingModel__Group__5__Impl )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:548:2: rule__PropertyBasedLockingModel__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__PropertyBasedLockingModel__Group__5__Impl_in_rule__PropertyBasedLockingModel__Group__51090);
            rule__PropertyBasedLockingModel__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyBasedLockingModel__Group__5"


    // $ANTLR start "rule__PropertyBasedLockingModel__Group__5__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:554:1: rule__PropertyBasedLockingModel__Group__5__Impl : ( '}' ) ;
    public final void rule__PropertyBasedLockingModel__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:558:1: ( ( '}' ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:559:1: ( '}' )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:559:1: ( '}' )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:560:1: '}'
            {
             before(grammarAccess.getPropertyBasedLockingModelAccess().getRightCurlyBracketKeyword_5()); 
            match(input,13,FOLLOW_13_in_rule__PropertyBasedLockingModel__Group__5__Impl1118); 
             after(grammarAccess.getPropertyBasedLockingModelAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyBasedLockingModel__Group__5__Impl"


    // $ANTLR start "rule__User__Group__0"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:585:1: rule__User__Group__0 : rule__User__Group__0__Impl rule__User__Group__1 ;
    public final void rule__User__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:589:1: ( rule__User__Group__0__Impl rule__User__Group__1 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:590:2: rule__User__Group__0__Impl rule__User__Group__1
            {
            pushFollow(FOLLOW_rule__User__Group__0__Impl_in_rule__User__Group__01161);
            rule__User__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__User__Group__1_in_rule__User__Group__01164);
            rule__User__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__0"


    // $ANTLR start "rule__User__Group__0__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:597:1: rule__User__Group__0__Impl : ( 'user' ) ;
    public final void rule__User__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:601:1: ( ( 'user' ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:602:1: ( 'user' )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:602:1: ( 'user' )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:603:1: 'user'
            {
             before(grammarAccess.getUserAccess().getUserKeyword_0()); 
            match(input,14,FOLLOW_14_in_rule__User__Group__0__Impl1192); 
             after(grammarAccess.getUserAccess().getUserKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__0__Impl"


    // $ANTLR start "rule__User__Group__1"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:616:1: rule__User__Group__1 : rule__User__Group__1__Impl ;
    public final void rule__User__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:620:1: ( rule__User__Group__1__Impl )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:621:2: rule__User__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__User__Group__1__Impl_in_rule__User__Group__11223);
            rule__User__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__1"


    // $ANTLR start "rule__User__Group__1__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:627:1: rule__User__Group__1__Impl : ( ( rule__User__NameAssignment_1 ) ) ;
    public final void rule__User__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:631:1: ( ( ( rule__User__NameAssignment_1 ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:632:1: ( ( rule__User__NameAssignment_1 ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:632:1: ( ( rule__User__NameAssignment_1 ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:633:1: ( rule__User__NameAssignment_1 )
            {
             before(grammarAccess.getUserAccess().getNameAssignment_1()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:634:1: ( rule__User__NameAssignment_1 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:634:2: rule__User__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__User__NameAssignment_1_in_rule__User__Group__1__Impl1250);
            rule__User__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getUserAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__Group__1__Impl"


    // $ANTLR start "rule__Group__Group__0"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:648:1: rule__Group__Group__0 : rule__Group__Group__0__Impl rule__Group__Group__1 ;
    public final void rule__Group__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:652:1: ( rule__Group__Group__0__Impl rule__Group__Group__1 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:653:2: rule__Group__Group__0__Impl rule__Group__Group__1
            {
            pushFollow(FOLLOW_rule__Group__Group__0__Impl_in_rule__Group__Group__01284);
            rule__Group__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Group__Group__1_in_rule__Group__Group__01287);
            rule__Group__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__0"


    // $ANTLR start "rule__Group__Group__0__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:660:1: rule__Group__Group__0__Impl : ( 'group' ) ;
    public final void rule__Group__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:664:1: ( ( 'group' ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:665:1: ( 'group' )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:665:1: ( 'group' )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:666:1: 'group'
            {
             before(grammarAccess.getGroupAccess().getGroupKeyword_0()); 
            match(input,15,FOLLOW_15_in_rule__Group__Group__0__Impl1315); 
             after(grammarAccess.getGroupAccess().getGroupKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__0__Impl"


    // $ANTLR start "rule__Group__Group__1"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:679:1: rule__Group__Group__1 : rule__Group__Group__1__Impl rule__Group__Group__2 ;
    public final void rule__Group__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:683:1: ( rule__Group__Group__1__Impl rule__Group__Group__2 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:684:2: rule__Group__Group__1__Impl rule__Group__Group__2
            {
            pushFollow(FOLLOW_rule__Group__Group__1__Impl_in_rule__Group__Group__11346);
            rule__Group__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Group__Group__2_in_rule__Group__Group__11349);
            rule__Group__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__1"


    // $ANTLR start "rule__Group__Group__1__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:691:1: rule__Group__Group__1__Impl : ( ( rule__Group__NameAssignment_1 ) ) ;
    public final void rule__Group__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:695:1: ( ( ( rule__Group__NameAssignment_1 ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:696:1: ( ( rule__Group__NameAssignment_1 ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:696:1: ( ( rule__Group__NameAssignment_1 ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:697:1: ( rule__Group__NameAssignment_1 )
            {
             before(grammarAccess.getGroupAccess().getNameAssignment_1()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:698:1: ( rule__Group__NameAssignment_1 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:698:2: rule__Group__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Group__NameAssignment_1_in_rule__Group__Group__1__Impl1376);
            rule__Group__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGroupAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__1__Impl"


    // $ANTLR start "rule__Group__Group__2"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:708:1: rule__Group__Group__2 : rule__Group__Group__2__Impl rule__Group__Group__3 ;
    public final void rule__Group__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:712:1: ( rule__Group__Group__2__Impl rule__Group__Group__3 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:713:2: rule__Group__Group__2__Impl rule__Group__Group__3
            {
            pushFollow(FOLLOW_rule__Group__Group__2__Impl_in_rule__Group__Group__21406);
            rule__Group__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Group__Group__3_in_rule__Group__Group__21409);
            rule__Group__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__2"


    // $ANTLR start "rule__Group__Group__2__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:720:1: rule__Group__Group__2__Impl : ( '{' ) ;
    public final void rule__Group__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:724:1: ( ( '{' ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:725:1: ( '{' )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:725:1: ( '{' )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:726:1: '{'
            {
             before(grammarAccess.getGroupAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,12,FOLLOW_12_in_rule__Group__Group__2__Impl1437); 
             after(grammarAccess.getGroupAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__2__Impl"


    // $ANTLR start "rule__Group__Group__3"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:739:1: rule__Group__Group__3 : rule__Group__Group__3__Impl rule__Group__Group__4 ;
    public final void rule__Group__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:743:1: ( rule__Group__Group__3__Impl rule__Group__Group__4 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:744:2: rule__Group__Group__3__Impl rule__Group__Group__4
            {
            pushFollow(FOLLOW_rule__Group__Group__3__Impl_in_rule__Group__Group__31468);
            rule__Group__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Group__Group__4_in_rule__Group__Group__31471);
            rule__Group__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__3"


    // $ANTLR start "rule__Group__Group__3__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:751:1: rule__Group__Group__3__Impl : ( ( rule__Group__UsersAssignment_3 ) ) ;
    public final void rule__Group__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:755:1: ( ( ( rule__Group__UsersAssignment_3 ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:756:1: ( ( rule__Group__UsersAssignment_3 ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:756:1: ( ( rule__Group__UsersAssignment_3 ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:757:1: ( rule__Group__UsersAssignment_3 )
            {
             before(grammarAccess.getGroupAccess().getUsersAssignment_3()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:758:1: ( rule__Group__UsersAssignment_3 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:758:2: rule__Group__UsersAssignment_3
            {
            pushFollow(FOLLOW_rule__Group__UsersAssignment_3_in_rule__Group__Group__3__Impl1498);
            rule__Group__UsersAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getGroupAccess().getUsersAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__3__Impl"


    // $ANTLR start "rule__Group__Group__4"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:768:1: rule__Group__Group__4 : rule__Group__Group__4__Impl rule__Group__Group__5 ;
    public final void rule__Group__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:772:1: ( rule__Group__Group__4__Impl rule__Group__Group__5 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:773:2: rule__Group__Group__4__Impl rule__Group__Group__5
            {
            pushFollow(FOLLOW_rule__Group__Group__4__Impl_in_rule__Group__Group__41528);
            rule__Group__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Group__Group__5_in_rule__Group__Group__41531);
            rule__Group__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__4"


    // $ANTLR start "rule__Group__Group__4__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:780:1: rule__Group__Group__4__Impl : ( ( rule__Group__Group_4__0 )* ) ;
    public final void rule__Group__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:784:1: ( ( ( rule__Group__Group_4__0 )* ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:785:1: ( ( rule__Group__Group_4__0 )* )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:785:1: ( ( rule__Group__Group_4__0 )* )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:786:1: ( rule__Group__Group_4__0 )*
            {
             before(grammarAccess.getGroupAccess().getGroup_4()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:787:1: ( rule__Group__Group_4__0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==16) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:787:2: rule__Group__Group_4__0
            	    {
            	    pushFollow(FOLLOW_rule__Group__Group_4__0_in_rule__Group__Group__4__Impl1558);
            	    rule__Group__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getGroupAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__4__Impl"


    // $ANTLR start "rule__Group__Group__5"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:797:1: rule__Group__Group__5 : rule__Group__Group__5__Impl ;
    public final void rule__Group__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:801:1: ( rule__Group__Group__5__Impl )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:802:2: rule__Group__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__Group__Group__5__Impl_in_rule__Group__Group__51589);
            rule__Group__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__5"


    // $ANTLR start "rule__Group__Group__5__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:808:1: rule__Group__Group__5__Impl : ( '}' ) ;
    public final void rule__Group__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:812:1: ( ( '}' ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:813:1: ( '}' )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:813:1: ( '}' )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:814:1: '}'
            {
             before(grammarAccess.getGroupAccess().getRightCurlyBracketKeyword_5()); 
            match(input,13,FOLLOW_13_in_rule__Group__Group__5__Impl1617); 
             after(grammarAccess.getGroupAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__5__Impl"


    // $ANTLR start "rule__Group__Group_4__0"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:839:1: rule__Group__Group_4__0 : rule__Group__Group_4__0__Impl rule__Group__Group_4__1 ;
    public final void rule__Group__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:843:1: ( rule__Group__Group_4__0__Impl rule__Group__Group_4__1 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:844:2: rule__Group__Group_4__0__Impl rule__Group__Group_4__1
            {
            pushFollow(FOLLOW_rule__Group__Group_4__0__Impl_in_rule__Group__Group_4__01660);
            rule__Group__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Group__Group_4__1_in_rule__Group__Group_4__01663);
            rule__Group__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group_4__0"


    // $ANTLR start "rule__Group__Group_4__0__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:851:1: rule__Group__Group_4__0__Impl : ( ',' ) ;
    public final void rule__Group__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:855:1: ( ( ',' ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:856:1: ( ',' )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:856:1: ( ',' )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:857:1: ','
            {
             before(grammarAccess.getGroupAccess().getCommaKeyword_4_0()); 
            match(input,16,FOLLOW_16_in_rule__Group__Group_4__0__Impl1691); 
             after(grammarAccess.getGroupAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group_4__0__Impl"


    // $ANTLR start "rule__Group__Group_4__1"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:870:1: rule__Group__Group_4__1 : rule__Group__Group_4__1__Impl ;
    public final void rule__Group__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:874:1: ( rule__Group__Group_4__1__Impl )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:875:2: rule__Group__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Group__Group_4__1__Impl_in_rule__Group__Group_4__11722);
            rule__Group__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group_4__1"


    // $ANTLR start "rule__Group__Group_4__1__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:881:1: rule__Group__Group_4__1__Impl : ( ( rule__Group__UsersAssignment_4_1 ) ) ;
    public final void rule__Group__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:885:1: ( ( ( rule__Group__UsersAssignment_4_1 ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:886:1: ( ( rule__Group__UsersAssignment_4_1 ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:886:1: ( ( rule__Group__UsersAssignment_4_1 ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:887:1: ( rule__Group__UsersAssignment_4_1 )
            {
             before(grammarAccess.getGroupAccess().getUsersAssignment_4_1()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:888:1: ( rule__Group__UsersAssignment_4_1 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:888:2: rule__Group__UsersAssignment_4_1
            {
            pushFollow(FOLLOW_rule__Group__UsersAssignment_4_1_in_rule__Group__Group_4__1__Impl1749);
            rule__Group__UsersAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getGroupAccess().getUsersAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group_4__1__Impl"


    // $ANTLR start "rule__Lock__Group__0"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:902:1: rule__Lock__Group__0 : rule__Lock__Group__0__Impl rule__Lock__Group__1 ;
    public final void rule__Lock__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:906:1: ( rule__Lock__Group__0__Impl rule__Lock__Group__1 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:907:2: rule__Lock__Group__0__Impl rule__Lock__Group__1
            {
            pushFollow(FOLLOW_rule__Lock__Group__0__Impl_in_rule__Lock__Group__01783);
            rule__Lock__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Lock__Group__1_in_rule__Lock__Group__01786);
            rule__Lock__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lock__Group__0"


    // $ANTLR start "rule__Lock__Group__0__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:914:1: rule__Lock__Group__0__Impl : ( ( rule__Lock__OwnerAssignment_0 ) ) ;
    public final void rule__Lock__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:918:1: ( ( ( rule__Lock__OwnerAssignment_0 ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:919:1: ( ( rule__Lock__OwnerAssignment_0 ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:919:1: ( ( rule__Lock__OwnerAssignment_0 ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:920:1: ( rule__Lock__OwnerAssignment_0 )
            {
             before(grammarAccess.getLockAccess().getOwnerAssignment_0()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:921:1: ( rule__Lock__OwnerAssignment_0 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:921:2: rule__Lock__OwnerAssignment_0
            {
            pushFollow(FOLLOW_rule__Lock__OwnerAssignment_0_in_rule__Lock__Group__0__Impl1813);
            rule__Lock__OwnerAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getLockAccess().getOwnerAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lock__Group__0__Impl"


    // $ANTLR start "rule__Lock__Group__1"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:931:1: rule__Lock__Group__1 : rule__Lock__Group__1__Impl rule__Lock__Group__2 ;
    public final void rule__Lock__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:935:1: ( rule__Lock__Group__1__Impl rule__Lock__Group__2 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:936:2: rule__Lock__Group__1__Impl rule__Lock__Group__2
            {
            pushFollow(FOLLOW_rule__Lock__Group__1__Impl_in_rule__Lock__Group__11843);
            rule__Lock__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Lock__Group__2_in_rule__Lock__Group__11846);
            rule__Lock__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lock__Group__1"


    // $ANTLR start "rule__Lock__Group__1__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:943:1: rule__Lock__Group__1__Impl : ( 'lock' ) ;
    public final void rule__Lock__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:947:1: ( ( 'lock' ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:948:1: ( 'lock' )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:948:1: ( 'lock' )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:949:1: 'lock'
            {
             before(grammarAccess.getLockAccess().getLockKeyword_1()); 
            match(input,17,FOLLOW_17_in_rule__Lock__Group__1__Impl1874); 
             after(grammarAccess.getLockAccess().getLockKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lock__Group__1__Impl"


    // $ANTLR start "rule__Lock__Group__2"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:962:1: rule__Lock__Group__2 : rule__Lock__Group__2__Impl rule__Lock__Group__3 ;
    public final void rule__Lock__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:966:1: ( rule__Lock__Group__2__Impl rule__Lock__Group__3 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:967:2: rule__Lock__Group__2__Impl rule__Lock__Group__3
            {
            pushFollow(FOLLOW_rule__Lock__Group__2__Impl_in_rule__Lock__Group__21905);
            rule__Lock__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Lock__Group__3_in_rule__Lock__Group__21908);
            rule__Lock__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lock__Group__2"


    // $ANTLR start "rule__Lock__Group__2__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:974:1: rule__Lock__Group__2__Impl : ( '{' ) ;
    public final void rule__Lock__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:978:1: ( ( '{' ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:979:1: ( '{' )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:979:1: ( '{' )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:980:1: '{'
            {
             before(grammarAccess.getLockAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,12,FOLLOW_12_in_rule__Lock__Group__2__Impl1936); 
             after(grammarAccess.getLockAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lock__Group__2__Impl"


    // $ANTLR start "rule__Lock__Group__3"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:993:1: rule__Lock__Group__3 : rule__Lock__Group__3__Impl rule__Lock__Group__4 ;
    public final void rule__Lock__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:997:1: ( rule__Lock__Group__3__Impl rule__Lock__Group__4 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:998:2: rule__Lock__Group__3__Impl rule__Lock__Group__4
            {
            pushFollow(FOLLOW_rule__Lock__Group__3__Impl_in_rule__Lock__Group__31967);
            rule__Lock__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Lock__Group__4_in_rule__Lock__Group__31970);
            rule__Lock__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lock__Group__3"


    // $ANTLR start "rule__Lock__Group__3__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1005:1: rule__Lock__Group__3__Impl : ( 'query' ) ;
    public final void rule__Lock__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1009:1: ( ( 'query' ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1010:1: ( 'query' )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1010:1: ( 'query' )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1011:1: 'query'
            {
             before(grammarAccess.getLockAccess().getQueryKeyword_3()); 
            match(input,18,FOLLOW_18_in_rule__Lock__Group__3__Impl1998); 
             after(grammarAccess.getLockAccess().getQueryKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lock__Group__3__Impl"


    // $ANTLR start "rule__Lock__Group__4"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1024:1: rule__Lock__Group__4 : rule__Lock__Group__4__Impl rule__Lock__Group__5 ;
    public final void rule__Lock__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1028:1: ( rule__Lock__Group__4__Impl rule__Lock__Group__5 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1029:2: rule__Lock__Group__4__Impl rule__Lock__Group__5
            {
            pushFollow(FOLLOW_rule__Lock__Group__4__Impl_in_rule__Lock__Group__42029);
            rule__Lock__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Lock__Group__5_in_rule__Lock__Group__42032);
            rule__Lock__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lock__Group__4"


    // $ANTLR start "rule__Lock__Group__4__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1036:1: rule__Lock__Group__4__Impl : ( ( rule__Lock__PatternAssignment_4 ) ) ;
    public final void rule__Lock__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1040:1: ( ( ( rule__Lock__PatternAssignment_4 ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1041:1: ( ( rule__Lock__PatternAssignment_4 ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1041:1: ( ( rule__Lock__PatternAssignment_4 ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1042:1: ( rule__Lock__PatternAssignment_4 )
            {
             before(grammarAccess.getLockAccess().getPatternAssignment_4()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1043:1: ( rule__Lock__PatternAssignment_4 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1043:2: rule__Lock__PatternAssignment_4
            {
            pushFollow(FOLLOW_rule__Lock__PatternAssignment_4_in_rule__Lock__Group__4__Impl2059);
            rule__Lock__PatternAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getLockAccess().getPatternAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lock__Group__4__Impl"


    // $ANTLR start "rule__Lock__Group__5"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1053:1: rule__Lock__Group__5 : rule__Lock__Group__5__Impl rule__Lock__Group__6 ;
    public final void rule__Lock__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1057:1: ( rule__Lock__Group__5__Impl rule__Lock__Group__6 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1058:2: rule__Lock__Group__5__Impl rule__Lock__Group__6
            {
            pushFollow(FOLLOW_rule__Lock__Group__5__Impl_in_rule__Lock__Group__52089);
            rule__Lock__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Lock__Group__6_in_rule__Lock__Group__52092);
            rule__Lock__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lock__Group__5"


    // $ANTLR start "rule__Lock__Group__5__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1065:1: rule__Lock__Group__5__Impl : ( ( rule__Lock__BindingsAssignment_5 )* ) ;
    public final void rule__Lock__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1069:1: ( ( ( rule__Lock__BindingsAssignment_5 )* ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1070:1: ( ( rule__Lock__BindingsAssignment_5 )* )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1070:1: ( ( rule__Lock__BindingsAssignment_5 )* )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1071:1: ( rule__Lock__BindingsAssignment_5 )*
            {
             before(grammarAccess.getLockAccess().getBindingsAssignment_5()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1072:1: ( rule__Lock__BindingsAssignment_5 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1072:2: rule__Lock__BindingsAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__Lock__BindingsAssignment_5_in_rule__Lock__Group__5__Impl2119);
            	    rule__Lock__BindingsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getLockAccess().getBindingsAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lock__Group__5__Impl"


    // $ANTLR start "rule__Lock__Group__6"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1082:1: rule__Lock__Group__6 : rule__Lock__Group__6__Impl ;
    public final void rule__Lock__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1086:1: ( rule__Lock__Group__6__Impl )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1087:2: rule__Lock__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__Lock__Group__6__Impl_in_rule__Lock__Group__62150);
            rule__Lock__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lock__Group__6"


    // $ANTLR start "rule__Lock__Group__6__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1093:1: rule__Lock__Group__6__Impl : ( '}' ) ;
    public final void rule__Lock__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1097:1: ( ( '}' ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1098:1: ( '}' )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1098:1: ( '}' )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1099:1: '}'
            {
             before(grammarAccess.getLockAccess().getRightCurlyBracketKeyword_6()); 
            match(input,13,FOLLOW_13_in_rule__Lock__Group__6__Impl2178); 
             after(grammarAccess.getLockAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lock__Group__6__Impl"


    // $ANTLR start "rule__Binding__Group__0"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1126:1: rule__Binding__Group__0 : rule__Binding__Group__0__Impl rule__Binding__Group__1 ;
    public final void rule__Binding__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1130:1: ( rule__Binding__Group__0__Impl rule__Binding__Group__1 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1131:2: rule__Binding__Group__0__Impl rule__Binding__Group__1
            {
            pushFollow(FOLLOW_rule__Binding__Group__0__Impl_in_rule__Binding__Group__02223);
            rule__Binding__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Binding__Group__1_in_rule__Binding__Group__02226);
            rule__Binding__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binding__Group__0"


    // $ANTLR start "rule__Binding__Group__0__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1138:1: rule__Binding__Group__0__Impl : ( 'bind' ) ;
    public final void rule__Binding__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1142:1: ( ( 'bind' ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1143:1: ( 'bind' )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1143:1: ( 'bind' )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1144:1: 'bind'
            {
             before(grammarAccess.getBindingAccess().getBindKeyword_0()); 
            match(input,19,FOLLOW_19_in_rule__Binding__Group__0__Impl2254); 
             after(grammarAccess.getBindingAccess().getBindKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binding__Group__0__Impl"


    // $ANTLR start "rule__Binding__Group__1"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1157:1: rule__Binding__Group__1 : rule__Binding__Group__1__Impl rule__Binding__Group__2 ;
    public final void rule__Binding__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1161:1: ( rule__Binding__Group__1__Impl rule__Binding__Group__2 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1162:2: rule__Binding__Group__1__Impl rule__Binding__Group__2
            {
            pushFollow(FOLLOW_rule__Binding__Group__1__Impl_in_rule__Binding__Group__12285);
            rule__Binding__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Binding__Group__2_in_rule__Binding__Group__12288);
            rule__Binding__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binding__Group__1"


    // $ANTLR start "rule__Binding__Group__1__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1169:1: rule__Binding__Group__1__Impl : ( ( rule__Binding__ParamAssignment_1 ) ) ;
    public final void rule__Binding__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1173:1: ( ( ( rule__Binding__ParamAssignment_1 ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1174:1: ( ( rule__Binding__ParamAssignment_1 ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1174:1: ( ( rule__Binding__ParamAssignment_1 ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1175:1: ( rule__Binding__ParamAssignment_1 )
            {
             before(grammarAccess.getBindingAccess().getParamAssignment_1()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1176:1: ( rule__Binding__ParamAssignment_1 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1176:2: rule__Binding__ParamAssignment_1
            {
            pushFollow(FOLLOW_rule__Binding__ParamAssignment_1_in_rule__Binding__Group__1__Impl2315);
            rule__Binding__ParamAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getBindingAccess().getParamAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binding__Group__1__Impl"


    // $ANTLR start "rule__Binding__Group__2"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1186:1: rule__Binding__Group__2 : rule__Binding__Group__2__Impl ;
    public final void rule__Binding__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1190:1: ( rule__Binding__Group__2__Impl )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1191:2: rule__Binding__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Binding__Group__2__Impl_in_rule__Binding__Group__22345);
            rule__Binding__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binding__Group__2"


    // $ANTLR start "rule__Binding__Group__2__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1197:1: rule__Binding__Group__2__Impl : ( ( rule__Binding__ValueAssignment_2 ) ) ;
    public final void rule__Binding__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1201:1: ( ( ( rule__Binding__ValueAssignment_2 ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1202:1: ( ( rule__Binding__ValueAssignment_2 ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1202:1: ( ( rule__Binding__ValueAssignment_2 ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1203:1: ( rule__Binding__ValueAssignment_2 )
            {
             before(grammarAccess.getBindingAccess().getValueAssignment_2()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1204:1: ( rule__Binding__ValueAssignment_2 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1204:2: rule__Binding__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__Binding__ValueAssignment_2_in_rule__Binding__Group__2__Impl2372);
            rule__Binding__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getBindingAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binding__Group__2__Impl"


    // $ANTLR start "rule__RoleBind__Group__0"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1220:1: rule__RoleBind__Group__0 : rule__RoleBind__Group__0__Impl rule__RoleBind__Group__1 ;
    public final void rule__RoleBind__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1224:1: ( rule__RoleBind__Group__0__Impl rule__RoleBind__Group__1 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1225:2: rule__RoleBind__Group__0__Impl rule__RoleBind__Group__1
            {
            pushFollow(FOLLOW_rule__RoleBind__Group__0__Impl_in_rule__RoleBind__Group__02408);
            rule__RoleBind__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RoleBind__Group__1_in_rule__RoleBind__Group__02411);
            rule__RoleBind__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RoleBind__Group__0"


    // $ANTLR start "rule__RoleBind__Group__0__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1232:1: rule__RoleBind__Group__0__Impl : ( 'role' ) ;
    public final void rule__RoleBind__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1236:1: ( ( 'role' ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1237:1: ( 'role' )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1237:1: ( 'role' )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1238:1: 'role'
            {
             before(grammarAccess.getRoleBindAccess().getRoleKeyword_0()); 
            match(input,20,FOLLOW_20_in_rule__RoleBind__Group__0__Impl2439); 
             after(grammarAccess.getRoleBindAccess().getRoleKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RoleBind__Group__0__Impl"


    // $ANTLR start "rule__RoleBind__Group__1"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1251:1: rule__RoleBind__Group__1 : rule__RoleBind__Group__1__Impl ;
    public final void rule__RoleBind__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1255:1: ( rule__RoleBind__Group__1__Impl )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1256:2: rule__RoleBind__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RoleBind__Group__1__Impl_in_rule__RoleBind__Group__12470);
            rule__RoleBind__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RoleBind__Group__1"


    // $ANTLR start "rule__RoleBind__Group__1__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1262:1: rule__RoleBind__Group__1__Impl : ( ( rule__RoleBind__RoleAssignment_1 ) ) ;
    public final void rule__RoleBind__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1266:1: ( ( ( rule__RoleBind__RoleAssignment_1 ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1267:1: ( ( rule__RoleBind__RoleAssignment_1 ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1267:1: ( ( rule__RoleBind__RoleAssignment_1 ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1268:1: ( rule__RoleBind__RoleAssignment_1 )
            {
             before(grammarAccess.getRoleBindAccess().getRoleAssignment_1()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1269:1: ( rule__RoleBind__RoleAssignment_1 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1269:2: rule__RoleBind__RoleAssignment_1
            {
            pushFollow(FOLLOW_rule__RoleBind__RoleAssignment_1_in_rule__RoleBind__Group__1__Impl2497);
            rule__RoleBind__RoleAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRoleBindAccess().getRoleAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RoleBind__Group__1__Impl"


    // $ANTLR start "rule__ValueBind__Group__0"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1283:1: rule__ValueBind__Group__0 : rule__ValueBind__Group__0__Impl rule__ValueBind__Group__1 ;
    public final void rule__ValueBind__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1287:1: ( rule__ValueBind__Group__0__Impl rule__ValueBind__Group__1 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1288:2: rule__ValueBind__Group__0__Impl rule__ValueBind__Group__1
            {
            pushFollow(FOLLOW_rule__ValueBind__Group__0__Impl_in_rule__ValueBind__Group__02531);
            rule__ValueBind__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ValueBind__Group__1_in_rule__ValueBind__Group__02534);
            rule__ValueBind__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueBind__Group__0"


    // $ANTLR start "rule__ValueBind__Group__0__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1295:1: rule__ValueBind__Group__0__Impl : ( 'value' ) ;
    public final void rule__ValueBind__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1299:1: ( ( 'value' ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1300:1: ( 'value' )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1300:1: ( 'value' )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1301:1: 'value'
            {
             before(grammarAccess.getValueBindAccess().getValueKeyword_0()); 
            match(input,21,FOLLOW_21_in_rule__ValueBind__Group__0__Impl2562); 
             after(grammarAccess.getValueBindAccess().getValueKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueBind__Group__0__Impl"


    // $ANTLR start "rule__ValueBind__Group__1"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1314:1: rule__ValueBind__Group__1 : rule__ValueBind__Group__1__Impl ;
    public final void rule__ValueBind__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1318:1: ( rule__ValueBind__Group__1__Impl )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1319:2: rule__ValueBind__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ValueBind__Group__1__Impl_in_rule__ValueBind__Group__12593);
            rule__ValueBind__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueBind__Group__1"


    // $ANTLR start "rule__ValueBind__Group__1__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1325:1: rule__ValueBind__Group__1__Impl : ( ( rule__ValueBind__ValueAssignment_1 ) ) ;
    public final void rule__ValueBind__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1329:1: ( ( ( rule__ValueBind__ValueAssignment_1 ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1330:1: ( ( rule__ValueBind__ValueAssignment_1 ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1330:1: ( ( rule__ValueBind__ValueAssignment_1 ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1331:1: ( rule__ValueBind__ValueAssignment_1 )
            {
             before(grammarAccess.getValueBindAccess().getValueAssignment_1()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1332:1: ( rule__ValueBind__ValueAssignment_1 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1332:2: rule__ValueBind__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__ValueBind__ValueAssignment_1_in_rule__ValueBind__Group__1__Impl2620);
            rule__ValueBind__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getValueBindAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueBind__Group__1__Impl"


    // $ANTLR start "rule__ObjectBind__Group__0"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1346:1: rule__ObjectBind__Group__0 : rule__ObjectBind__Group__0__Impl rule__ObjectBind__Group__1 ;
    public final void rule__ObjectBind__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1350:1: ( rule__ObjectBind__Group__0__Impl rule__ObjectBind__Group__1 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1351:2: rule__ObjectBind__Group__0__Impl rule__ObjectBind__Group__1
            {
            pushFollow(FOLLOW_rule__ObjectBind__Group__0__Impl_in_rule__ObjectBind__Group__02654);
            rule__ObjectBind__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ObjectBind__Group__1_in_rule__ObjectBind__Group__02657);
            rule__ObjectBind__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectBind__Group__0"


    // $ANTLR start "rule__ObjectBind__Group__0__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1358:1: rule__ObjectBind__Group__0__Impl : ( 'object' ) ;
    public final void rule__ObjectBind__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1362:1: ( ( 'object' ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1363:1: ( 'object' )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1363:1: ( 'object' )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1364:1: 'object'
            {
             before(grammarAccess.getObjectBindAccess().getObjectKeyword_0()); 
            match(input,22,FOLLOW_22_in_rule__ObjectBind__Group__0__Impl2685); 
             after(grammarAccess.getObjectBindAccess().getObjectKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectBind__Group__0__Impl"


    // $ANTLR start "rule__ObjectBind__Group__1"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1377:1: rule__ObjectBind__Group__1 : rule__ObjectBind__Group__1__Impl ;
    public final void rule__ObjectBind__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1381:1: ( rule__ObjectBind__Group__1__Impl )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1382:2: rule__ObjectBind__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ObjectBind__Group__1__Impl_in_rule__ObjectBind__Group__12716);
            rule__ObjectBind__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectBind__Group__1"


    // $ANTLR start "rule__ObjectBind__Group__1__Impl"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1388:1: rule__ObjectBind__Group__1__Impl : ( ( rule__ObjectBind__ObjectAssignment_1 ) ) ;
    public final void rule__ObjectBind__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1392:1: ( ( ( rule__ObjectBind__ObjectAssignment_1 ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1393:1: ( ( rule__ObjectBind__ObjectAssignment_1 ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1393:1: ( ( rule__ObjectBind__ObjectAssignment_1 ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1394:1: ( rule__ObjectBind__ObjectAssignment_1 )
            {
             before(grammarAccess.getObjectBindAccess().getObjectAssignment_1()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1395:1: ( rule__ObjectBind__ObjectAssignment_1 )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1395:2: rule__ObjectBind__ObjectAssignment_1
            {
            pushFollow(FOLLOW_rule__ObjectBind__ObjectAssignment_1_in_rule__ObjectBind__Group__1__Impl2743);
            rule__ObjectBind__ObjectAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getObjectBindAccess().getObjectAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectBind__Group__1__Impl"


    // $ANTLR start "rule__PropertyBasedLockingModel__RolesAssignment_1"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1410:1: rule__PropertyBasedLockingModel__RolesAssignment_1 : ( ruleRole ) ;
    public final void rule__PropertyBasedLockingModel__RolesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1414:1: ( ( ruleRole ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1415:1: ( ruleRole )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1415:1: ( ruleRole )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1416:1: ruleRole
            {
             before(grammarAccess.getPropertyBasedLockingModelAccess().getRolesRoleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleRole_in_rule__PropertyBasedLockingModel__RolesAssignment_12782);
            ruleRole();

            state._fsp--;

             after(grammarAccess.getPropertyBasedLockingModelAccess().getRolesRoleParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyBasedLockingModel__RolesAssignment_1"


    // $ANTLR start "rule__PropertyBasedLockingModel__LocksAssignment_4"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1425:1: rule__PropertyBasedLockingModel__LocksAssignment_4 : ( ruleLock ) ;
    public final void rule__PropertyBasedLockingModel__LocksAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1429:1: ( ( ruleLock ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1430:1: ( ruleLock )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1430:1: ( ruleLock )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1431:1: ruleLock
            {
             before(grammarAccess.getPropertyBasedLockingModelAccess().getLocksLockParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleLock_in_rule__PropertyBasedLockingModel__LocksAssignment_42813);
            ruleLock();

            state._fsp--;

             after(grammarAccess.getPropertyBasedLockingModelAccess().getLocksLockParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyBasedLockingModel__LocksAssignment_4"


    // $ANTLR start "rule__User__NameAssignment_1"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1440:1: rule__User__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__User__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1444:1: ( ( RULE_ID ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1445:1: ( RULE_ID )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1445:1: ( RULE_ID )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1446:1: RULE_ID
            {
             before(grammarAccess.getUserAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__User__NameAssignment_12844); 
             after(grammarAccess.getUserAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__User__NameAssignment_1"


    // $ANTLR start "rule__Group__NameAssignment_1"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1455:1: rule__Group__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Group__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1459:1: ( ( RULE_ID ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1460:1: ( RULE_ID )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1460:1: ( RULE_ID )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1461:1: RULE_ID
            {
             before(grammarAccess.getGroupAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Group__NameAssignment_12875); 
             after(grammarAccess.getGroupAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__NameAssignment_1"


    // $ANTLR start "rule__Group__UsersAssignment_3"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1470:1: rule__Group__UsersAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Group__UsersAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1474:1: ( ( ( RULE_ID ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1475:1: ( ( RULE_ID ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1475:1: ( ( RULE_ID ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1476:1: ( RULE_ID )
            {
             before(grammarAccess.getGroupAccess().getUsersUserCrossReference_3_0()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1477:1: ( RULE_ID )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1478:1: RULE_ID
            {
             before(grammarAccess.getGroupAccess().getUsersUserIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Group__UsersAssignment_32910); 
             after(grammarAccess.getGroupAccess().getUsersUserIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getGroupAccess().getUsersUserCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__UsersAssignment_3"


    // $ANTLR start "rule__Group__UsersAssignment_4_1"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1489:1: rule__Group__UsersAssignment_4_1 : ( ( RULE_ID ) ) ;
    public final void rule__Group__UsersAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1493:1: ( ( ( RULE_ID ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1494:1: ( ( RULE_ID ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1494:1: ( ( RULE_ID ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1495:1: ( RULE_ID )
            {
             before(grammarAccess.getGroupAccess().getUsersUserCrossReference_4_1_0()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1496:1: ( RULE_ID )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1497:1: RULE_ID
            {
             before(grammarAccess.getGroupAccess().getUsersUserIDTerminalRuleCall_4_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Group__UsersAssignment_4_12949); 
             after(grammarAccess.getGroupAccess().getUsersUserIDTerminalRuleCall_4_1_0_1()); 

            }

             after(grammarAccess.getGroupAccess().getUsersUserCrossReference_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__UsersAssignment_4_1"


    // $ANTLR start "rule__Lock__OwnerAssignment_0"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1508:1: rule__Lock__OwnerAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__Lock__OwnerAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1512:1: ( ( ( RULE_ID ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1513:1: ( ( RULE_ID ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1513:1: ( ( RULE_ID ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1514:1: ( RULE_ID )
            {
             before(grammarAccess.getLockAccess().getOwnerRoleCrossReference_0_0()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1515:1: ( RULE_ID )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1516:1: RULE_ID
            {
             before(grammarAccess.getLockAccess().getOwnerRoleIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Lock__OwnerAssignment_02988); 
             after(grammarAccess.getLockAccess().getOwnerRoleIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getLockAccess().getOwnerRoleCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lock__OwnerAssignment_0"


    // $ANTLR start "rule__Lock__PatternAssignment_4"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1527:1: rule__Lock__PatternAssignment_4 : ( ( RULE_STRING ) ) ;
    public final void rule__Lock__PatternAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1531:1: ( ( ( RULE_STRING ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1532:1: ( ( RULE_STRING ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1532:1: ( ( RULE_STRING ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1533:1: ( RULE_STRING )
            {
             before(grammarAccess.getLockAccess().getPatternPatternCrossReference_4_0()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1534:1: ( RULE_STRING )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1535:1: RULE_STRING
            {
             before(grammarAccess.getLockAccess().getPatternPatternSTRINGTerminalRuleCall_4_0_1()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Lock__PatternAssignment_43027); 
             after(grammarAccess.getLockAccess().getPatternPatternSTRINGTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getLockAccess().getPatternPatternCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lock__PatternAssignment_4"


    // $ANTLR start "rule__Lock__BindingsAssignment_5"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1546:1: rule__Lock__BindingsAssignment_5 : ( ruleBinding ) ;
    public final void rule__Lock__BindingsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1550:1: ( ( ruleBinding ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1551:1: ( ruleBinding )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1551:1: ( ruleBinding )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1552:1: ruleBinding
            {
             before(grammarAccess.getLockAccess().getBindingsBindingParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleBinding_in_rule__Lock__BindingsAssignment_53062);
            ruleBinding();

            state._fsp--;

             after(grammarAccess.getLockAccess().getBindingsBindingParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lock__BindingsAssignment_5"


    // $ANTLR start "rule__Binding__ParamAssignment_1"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1561:1: rule__Binding__ParamAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Binding__ParamAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1565:1: ( ( ( RULE_ID ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1566:1: ( ( RULE_ID ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1566:1: ( ( RULE_ID ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1567:1: ( RULE_ID )
            {
             before(grammarAccess.getBindingAccess().getParamVariableCrossReference_1_0()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1568:1: ( RULE_ID )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1569:1: RULE_ID
            {
             before(grammarAccess.getBindingAccess().getParamVariableIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Binding__ParamAssignment_13097); 
             after(grammarAccess.getBindingAccess().getParamVariableIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getBindingAccess().getParamVariableCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binding__ParamAssignment_1"


    // $ANTLR start "rule__Binding__ValueAssignment_2"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1580:1: rule__Binding__ValueAssignment_2 : ( ruleBind ) ;
    public final void rule__Binding__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1584:1: ( ( ruleBind ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1585:1: ( ruleBind )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1585:1: ( ruleBind )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1586:1: ruleBind
            {
             before(grammarAccess.getBindingAccess().getValueBindParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleBind_in_rule__Binding__ValueAssignment_23132);
            ruleBind();

            state._fsp--;

             after(grammarAccess.getBindingAccess().getValueBindParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Binding__ValueAssignment_2"


    // $ANTLR start "rule__RoleBind__RoleAssignment_1"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1595:1: rule__RoleBind__RoleAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__RoleBind__RoleAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1599:1: ( ( ( RULE_ID ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1600:1: ( ( RULE_ID ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1600:1: ( ( RULE_ID ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1601:1: ( RULE_ID )
            {
             before(grammarAccess.getRoleBindAccess().getRoleRoleCrossReference_1_0()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1602:1: ( RULE_ID )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1603:1: RULE_ID
            {
             before(grammarAccess.getRoleBindAccess().getRoleRoleIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__RoleBind__RoleAssignment_13167); 
             after(grammarAccess.getRoleBindAccess().getRoleRoleIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getRoleBindAccess().getRoleRoleCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RoleBind__RoleAssignment_1"


    // $ANTLR start "rule__ValueBind__ValueAssignment_1"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1614:1: rule__ValueBind__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__ValueBind__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1618:1: ( ( RULE_STRING ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1619:1: ( RULE_STRING )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1619:1: ( RULE_STRING )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1620:1: RULE_STRING
            {
             before(grammarAccess.getValueBindAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ValueBind__ValueAssignment_13202); 
             after(grammarAccess.getValueBindAccess().getValueSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueBind__ValueAssignment_1"


    // $ANTLR start "rule__ObjectBind__ObjectAssignment_1"
    // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1629:1: rule__ObjectBind__ObjectAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ObjectBind__ObjectAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1633:1: ( ( ( RULE_ID ) ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1634:1: ( ( RULE_ID ) )
            {
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1634:1: ( ( RULE_ID ) )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1635:1: ( RULE_ID )
            {
             before(grammarAccess.getObjectBindAccess().getObjectEObjectCrossReference_1_0()); 
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1636:1: ( RULE_ID )
            // ../org.mondo.collaboration.security.mpbl.xtext.ui/src-gen/org/mondo/collaboration/security/mpbl/xtext/ui/contentassist/antlr/internal/InternalMondoPropertyBasedLocking.g:1637:1: RULE_ID
            {
             before(grammarAccess.getObjectBindAccess().getObjectEObjectIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ObjectBind__ObjectAssignment_13237); 
             after(grammarAccess.getObjectBindAccess().getObjectEObjectIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getObjectBindAccess().getObjectEObjectCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectBind__ObjectAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_rulePropertyBasedLockingModel_in_entryRulePropertyBasedLockingModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyBasedLockingModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyBasedLockingModel__Group__0_in_rulePropertyBasedLockingModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRole_in_entryRuleRole121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRole128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Role__Alternatives_in_ruleRole154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUser_in_entryRuleUser181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUser188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__User__Group__0_in_ruleUser214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroup248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Group__Group__0_in_ruleGroup274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLock_in_entryRuleLock301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLock308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Lock__Group__0_in_ruleLock334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBinding_in_entryRuleBinding361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBinding368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Binding__Group__0_in_ruleBinding394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBind_in_entryRuleBind421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBind428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Bind__Alternatives_in_ruleBind454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRoleBind_in_entryRuleRoleBind481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRoleBind488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RoleBind__Group__0_in_ruleRoleBind514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueBind_in_entryRuleValueBind541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueBind548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueBind__Group__0_in_ruleValueBind574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectBind_in_entryRuleObjectBind601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectBind608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectBind__Group__0_in_ruleObjectBind634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUser_in_rule__Role__Alternatives670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_rule__Role__Alternatives687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectBind_in_rule__Bind__Alternatives719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueBind_in_rule__Bind__Alternatives736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRoleBind_in_rule__Bind__Alternatives753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyBasedLockingModel__Group__0__Impl_in_rule__PropertyBasedLockingModel__Group__0783 = new BitSet(new long[]{0x000000000000C800L});
    public static final BitSet FOLLOW_rule__PropertyBasedLockingModel__Group__1_in_rule__PropertyBasedLockingModel__Group__0786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyBasedLockingModel__Group__1__Impl_in_rule__PropertyBasedLockingModel__Group__1844 = new BitSet(new long[]{0x000000000000C800L});
    public static final BitSet FOLLOW_rule__PropertyBasedLockingModel__Group__2_in_rule__PropertyBasedLockingModel__Group__1847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyBasedLockingModel__RolesAssignment_1_in_rule__PropertyBasedLockingModel__Group__1__Impl874 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_rule__PropertyBasedLockingModel__Group__2__Impl_in_rule__PropertyBasedLockingModel__Group__2905 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__PropertyBasedLockingModel__Group__3_in_rule__PropertyBasedLockingModel__Group__2908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__PropertyBasedLockingModel__Group__2__Impl936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyBasedLockingModel__Group__3__Impl_in_rule__PropertyBasedLockingModel__Group__3967 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_rule__PropertyBasedLockingModel__Group__4_in_rule__PropertyBasedLockingModel__Group__3970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__PropertyBasedLockingModel__Group__3__Impl998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyBasedLockingModel__Group__4__Impl_in_rule__PropertyBasedLockingModel__Group__41029 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_rule__PropertyBasedLockingModel__Group__5_in_rule__PropertyBasedLockingModel__Group__41032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyBasedLockingModel__LocksAssignment_4_in_rule__PropertyBasedLockingModel__Group__4__Impl1059 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__PropertyBasedLockingModel__Group__5__Impl_in_rule__PropertyBasedLockingModel__Group__51090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__PropertyBasedLockingModel__Group__5__Impl1118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__User__Group__0__Impl_in_rule__User__Group__01161 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__User__Group__1_in_rule__User__Group__01164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__User__Group__0__Impl1192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__User__Group__1__Impl_in_rule__User__Group__11223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__User__NameAssignment_1_in_rule__User__Group__1__Impl1250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Group__Group__0__Impl_in_rule__Group__Group__01284 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Group__Group__1_in_rule__Group__Group__01287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Group__Group__0__Impl1315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Group__Group__1__Impl_in_rule__Group__Group__11346 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Group__Group__2_in_rule__Group__Group__11349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Group__NameAssignment_1_in_rule__Group__Group__1__Impl1376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Group__Group__2__Impl_in_rule__Group__Group__21406 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Group__Group__3_in_rule__Group__Group__21409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Group__Group__2__Impl1437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Group__Group__3__Impl_in_rule__Group__Group__31468 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_rule__Group__Group__4_in_rule__Group__Group__31471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Group__UsersAssignment_3_in_rule__Group__Group__3__Impl1498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Group__Group__4__Impl_in_rule__Group__Group__41528 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_rule__Group__Group__5_in_rule__Group__Group__41531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Group__Group_4__0_in_rule__Group__Group__4__Impl1558 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__Group__Group__5__Impl_in_rule__Group__Group__51589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Group__Group__5__Impl1617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Group__Group_4__0__Impl_in_rule__Group__Group_4__01660 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Group__Group_4__1_in_rule__Group__Group_4__01663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Group__Group_4__0__Impl1691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Group__Group_4__1__Impl_in_rule__Group__Group_4__11722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Group__UsersAssignment_4_1_in_rule__Group__Group_4__1__Impl1749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Lock__Group__0__Impl_in_rule__Lock__Group__01783 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Lock__Group__1_in_rule__Lock__Group__01786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Lock__OwnerAssignment_0_in_rule__Lock__Group__0__Impl1813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Lock__Group__1__Impl_in_rule__Lock__Group__11843 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Lock__Group__2_in_rule__Lock__Group__11846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Lock__Group__1__Impl1874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Lock__Group__2__Impl_in_rule__Lock__Group__21905 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Lock__Group__3_in_rule__Lock__Group__21908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Lock__Group__2__Impl1936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Lock__Group__3__Impl_in_rule__Lock__Group__31967 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Lock__Group__4_in_rule__Lock__Group__31970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Lock__Group__3__Impl1998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Lock__Group__4__Impl_in_rule__Lock__Group__42029 = new BitSet(new long[]{0x0000000000082000L});
    public static final BitSet FOLLOW_rule__Lock__Group__5_in_rule__Lock__Group__42032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Lock__PatternAssignment_4_in_rule__Lock__Group__4__Impl2059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Lock__Group__5__Impl_in_rule__Lock__Group__52089 = new BitSet(new long[]{0x0000000000082000L});
    public static final BitSet FOLLOW_rule__Lock__Group__6_in_rule__Lock__Group__52092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Lock__BindingsAssignment_5_in_rule__Lock__Group__5__Impl2119 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_rule__Lock__Group__6__Impl_in_rule__Lock__Group__62150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Lock__Group__6__Impl2178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Binding__Group__0__Impl_in_rule__Binding__Group__02223 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Binding__Group__1_in_rule__Binding__Group__02226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Binding__Group__0__Impl2254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Binding__Group__1__Impl_in_rule__Binding__Group__12285 = new BitSet(new long[]{0x0000000000700000L});
    public static final BitSet FOLLOW_rule__Binding__Group__2_in_rule__Binding__Group__12288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Binding__ParamAssignment_1_in_rule__Binding__Group__1__Impl2315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Binding__Group__2__Impl_in_rule__Binding__Group__22345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Binding__ValueAssignment_2_in_rule__Binding__Group__2__Impl2372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RoleBind__Group__0__Impl_in_rule__RoleBind__Group__02408 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RoleBind__Group__1_in_rule__RoleBind__Group__02411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__RoleBind__Group__0__Impl2439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RoleBind__Group__1__Impl_in_rule__RoleBind__Group__12470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RoleBind__RoleAssignment_1_in_rule__RoleBind__Group__1__Impl2497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueBind__Group__0__Impl_in_rule__ValueBind__Group__02531 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ValueBind__Group__1_in_rule__ValueBind__Group__02534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ValueBind__Group__0__Impl2562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueBind__Group__1__Impl_in_rule__ValueBind__Group__12593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueBind__ValueAssignment_1_in_rule__ValueBind__Group__1__Impl2620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectBind__Group__0__Impl_in_rule__ObjectBind__Group__02654 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ObjectBind__Group__1_in_rule__ObjectBind__Group__02657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ObjectBind__Group__0__Impl2685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectBind__Group__1__Impl_in_rule__ObjectBind__Group__12716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectBind__ObjectAssignment_1_in_rule__ObjectBind__Group__1__Impl2743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRole_in_rule__PropertyBasedLockingModel__RolesAssignment_12782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLock_in_rule__PropertyBasedLockingModel__LocksAssignment_42813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__User__NameAssignment_12844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Group__NameAssignment_12875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Group__UsersAssignment_32910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Group__UsersAssignment_4_12949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Lock__OwnerAssignment_02988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Lock__PatternAssignment_43027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBinding_in_rule__Lock__BindingsAssignment_53062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Binding__ParamAssignment_13097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBind_in_rule__Binding__ValueAssignment_23132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__RoleBind__RoleAssignment_13167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ValueBind__ValueAssignment_13202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ObjectBind__ObjectAssignment_13237 = new BitSet(new long[]{0x0000000000000002L});

}