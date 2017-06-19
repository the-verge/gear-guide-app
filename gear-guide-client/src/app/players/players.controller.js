export default class PlayerController {

    constructor(Player) {
        'ngInject';

        this.players = Player.get();
    }

}
