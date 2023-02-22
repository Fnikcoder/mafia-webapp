package com.first.firstspringbootproject.player;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@Controller
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/playersList")
    private String playersList(Model model) throws ExecutionException, InterruptedException {
        model.addAttribute("playerList", playerService.getAllPlayersDetails());
        return "players";
    }
    @GetMapping("/getPlayerDetails")
    public String getPlayerDetails() throws InterruptedException, ExecutionException{
        return playerService.getPlayerDetails("5970439325");
    }

//    fix
    @PostMapping("/createPlayer")
    public String createPlayer(@RequestBody Player player) throws InterruptedException, ExecutionException {
        return playerService.savePlayer(player);
    }

    @PutMapping("/updatePlayer")
    public String updatePlayer(@RequestBody Player player) throws InterruptedException, ExecutionException {
        return playerService.updatePlayer(player);
    }

    @DeleteMapping("/deletePlayer")

    public String deletePlayer(@RequestParam String id){
        return playerService.deletePlayer(id);
    }

}
