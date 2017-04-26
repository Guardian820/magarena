package magic.ui.screen.duel.game;

import javax.swing.JPanel;
import magic.model.MagicCardList;
import magic.ui.duel.resolution.ResolutionProfileResult;
import magic.ui.duel.viewerinfo.CardViewerInfo;

@SuppressWarnings("serial")
public abstract class BattlefieldPanel extends JPanel {

    public abstract void doUpdate();

    public abstract void showCards(final MagicCardList cards);

    public abstract void focusViewers(final int handGraveyard);

    public abstract void resizeComponents(final ResolutionProfileResult result);

    public abstract void highlightCard(CardViewerInfo cardInfo, boolean b);

}
