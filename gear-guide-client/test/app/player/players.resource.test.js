//import PlayerResource from '../../../src/app/player/player.resource';
//import * as angular from '../../../bower_components/angular/angular';
import '../../../bower_components/angular-mocks/ngMock';

describe('PlayerResource test', () => {

    let Player;

    // beforeEach(angular.mock.module('app.core'));
    // beforeEach(angular.mock.module('app.routing'));
    beforeEach(angular.mock.module('app.player'));

    beforeEach(angular.mock.inject((_Player_) => {
        Player = _Player_;
    }));

    it('should exist', () => {
        expect(Player).toBeDefined();
    });
});