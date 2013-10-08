package magic.model;

public interface MagicObject extends MagicCopyable {
    boolean     isSpell();
    boolean     isSpell(MagicType type);
    boolean     isInstantOrSorcerySpell();
    boolean     isPlayer();
    boolean     isPermanent();
    boolean     isCreature();
    boolean     isPlaneswalker();
    boolean     hasColor(final MagicColor color);
    boolean     hasAbility(final MagicAbility ability);
    boolean     hasType(final MagicType type);
    boolean     hasSubType(final MagicSubType subType);
    String      getName();
    MagicPlayer getController();
    MagicPlayer getOpponent();
    boolean     isFriend(final MagicObject other);
    boolean     isEnemy(final MagicObject other);
    long        getStateId();
    MagicCardDefinition getCardDefinition();
}
