/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

export const DagNodeName = 'dag-node'
export const DagEdgeName = 'dag-edge'
export const NodeWidth = 200
export const NodeHeight = 50
export const NodeShape = 'rect'
export const PortAttrs = {
  circle: {
    r: 4,
    magnet: true,
    stroke: '#C2C8D5',
    strokeWidth: 1,
    fill: '#fff'
  }
}
export const PortGroupsConfig = {
  in: {
    position: 'left',
    attrs: PortAttrs
  },
  out: {
    position: 'right',
    attrs: PortAttrs
  }
}
export const EdgeDefaultConfig = {
  attrs: {
    line: {
      stroke: '#C2C8D5',
      strokeWidth: 1
    }
  }
}
