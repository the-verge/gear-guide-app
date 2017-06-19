import coreModule from './core/core.module';
import routingModule from './routing/routing.module';
import playerModule from './players/players.module';

angular.module('app', [
    coreModule,
    routingModule,
    playerModule
]);