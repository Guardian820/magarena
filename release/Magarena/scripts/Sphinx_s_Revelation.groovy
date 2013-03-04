[
    new MagicSpellCardEvent() {
        @Override
        public MagicEvent getEvent(final MagicCardOnStack cardOnStack,final MagicPayedCost payedCost) {
            final int amount=payedCost.getX();
            return new MagicEvent(
                cardOnStack,
                this,
                "PN gains " + amount + " life and draw " + amount + " cards."
            );
        }
        @Override
        public void executeEvent(
                final MagicGame game,
                final MagicEvent event,
                final Object[] choiceResults) {
            final int amount = event.getCardOnStack().getX();
            game.doAction(new MagicChangeLifeAction(event.getPlayer(), amount));
            game.doAction(new MagicDrawAction(event.getPlayer(), amount));
        }
    }
]
