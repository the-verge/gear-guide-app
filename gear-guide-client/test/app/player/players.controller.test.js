import PlayersController from '../../../src/app/players/players.controller';

describe('PlayersController test', () => {

    let controller;

    beforeEach(() => {
        angular.mock.module('app.player');
        controller = new PlayersController();
    });

});