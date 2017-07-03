import coreModule from './core/core.module';
import routingModule from './routing/routing.module';
import playersModule from './players/players.module';
import guitarsModule from './guitars/guitars.module';
import amplifiersModule from './amplifiers/amplifiers.module';
import adminModule from './admin/admin.module';
import manufacturersModule from './manufacturers/manufacturers.module';

angular.module('app', [
    coreModule,
    routingModule,
    playersModule,
    guitarsModule,
    amplifiersModule,
    adminModule,
    manufacturersModule
]);