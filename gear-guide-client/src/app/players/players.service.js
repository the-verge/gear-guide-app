export default class PlayersService {
    constructor(playerResource) {
        'ngInject';

        this.playerResource = playerResource;
    }

    getPlayers() {
        return this.playerResource.get();
    }

    createPlayer(playerData) {
        return this.playerResource.create(playerData).$promise;
    }
}