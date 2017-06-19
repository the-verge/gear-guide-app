import PlayerController from '../../../src/app/players/players.controller';

describe('PlayerController test', () => {

    let controller;

    beforeEach(() => {
        angular.mock.module('app.player');
        controller = new PlayerController();
    });

    it('should return 2', () => {
        expect(controller.return2()).toEqual(2);
    });
});