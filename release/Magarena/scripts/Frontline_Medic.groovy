[
    new MagicBattalionTrigger() {
        @Override
        public MagicEvent executeTrigger(
                final MagicGame game,
                final MagicPermanent permanent,
                final MagicPermanent attacker) {
            return new MagicEvent(
                permanent,
                this,
                "Creatures PN controls are indestructible this turn."
            );
        }
        @Override
        public void executeEvent(
                final MagicGame game,
                final MagicEvent event,
                final Object[] choiceResults) {
            final Collection<MagicPermanent> creatures=
                game.filterPermanents(event.getPlayer(),MagicTargetFilter.TARGET_CREATURE_YOU_CONTROL);
            for (final MagicPermanent creature : creatures) {
                game.doAction(new MagicSetAbilityAction(creature,MagicAbility.Indestructible));
            }
        }
    },
    new MagicPermanentActivation(
        MagicActivation.NO_COND,
        new MagicActivationHints(MagicTiming.Counter),
        "Counter") {

        @Override
        public MagicEvent[] getCostEvent(final MagicPermanent source) {
            return [new MagicSacrificeEvent(source)];
        }

        @Override
        public MagicEvent getPermanentEvent(final MagicPermanent source,final MagicPayedCost payedCost) {
            return new MagicEvent(
                source,
                MagicTargetChoice.NEG_TARGET_SPELL_WITH_X_COST,
                this,
                "Counter target spell\$ with {X} in its mana cost unless its controller pays {3}."
            );
        }

        @Override
        public void executeEvent(final MagicGame game,final MagicEvent event,final Object[] choiceResults) {
            event.processTargetCardOnStack(game,choiceResults,0,new MagicCardOnStackAction() {
                public void doAction(final MagicCardOnStack targetSpell) {
                    game.addEvent(new MagicCounterUnlessEvent(event.getSource(),targetSpell,MagicManaCost.THREE)); 
                }
            });
        }
    }
]
