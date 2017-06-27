export default class PlayersService {
    constructor(playerResource) {
        'ngInject';

        this.playerResource = playerResource;
    }

    getPlayers() {
        return this.playerResource.get();
    }
}