import coreModule from './core/core.module';
import routingModule from './routing/routing.module';
import playersModule from './players/players.module';
import guitarsModule from './guitars/guitars.module';
import adminModule from './admin/admin.module';

angular.module('app', [
    coreModule,
    routingModule,
    playersModule,
    guitarsModule,
    adminModule
]);