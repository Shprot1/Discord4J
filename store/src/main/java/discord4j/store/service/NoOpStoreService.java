/*
 * This file is part of Discord4J.
 *
 * Discord4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Discord4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Discord4J.  If not, see <http://www.gnu.org/licenses/>.
 */
package discord4j.store.service;

import discord4j.store.ReactiveStore;
import discord4j.store.base.NoOpReactiveStore;
import discord4j.store.base.primitive.NoOpLongObjReactiveStore;
import discord4j.store.primitive.LongObjReactiveStore;
import reactor.core.publisher.Mono;

public class NoOpStoreService implements StoreService {

    @Override
    public boolean hasGenericStores() {
        return true;
    }

    @Override
    public <K, V> Mono<ReactiveStore<K, V>> provideGenericStore(Class<K> keyClass, Class<V> valueClass) {
        return Mono.just(new NoOpReactiveStore<>());
    }

    @Override
    public boolean hasPrimitiveStores() {
        return true;
    }

    @Override
    public <V> Mono<LongObjReactiveStore<V>> providePrimitiveStore(Class<V> valueClass) {
        return Mono.just(new NoOpLongObjReactiveStore<>());
    }
}
