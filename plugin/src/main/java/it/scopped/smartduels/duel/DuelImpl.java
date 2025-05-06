package it.scopped.smartduels.duel;

import it.scopped.smartduels.arena.Arena;
import it.scopped.smartduels.kit.Kit;
import it.scopped.smartduels.utility.PlayerUtil;
import org.bukkit.entity.Player;

public class DuelImpl implements Duel {

    private final Player sender;
    private final Player receiver;

    private final Kit selectedKit;
    private final Arena arena;

    public DuelImpl(Player sender, Player receiver, Kit selectedKit, Arena arena) {
        this.sender = sender;
        this.receiver = receiver;

        this.selectedKit = selectedKit;
        this.arena = arena;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {
        PlayerUtil.resetPlayer(sender, receiver);

        //sender.teleport(SPAWN_LOCATION);
        //receiver.teleport(SPAWN_LOCATION);

        arena.reset();
    }

    @Override
    public Player sender() {
        return sender;
    }

    @Override
    public Player receiver() {
        return receiver;
    }

    @Override
    public Kit selectedKit() {
        return selectedKit;
    }

    @Override
    public Arena arena() {
        return arena;
    }
}
