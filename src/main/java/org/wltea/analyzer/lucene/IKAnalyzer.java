/**
 * IK 中文分词  版本 5.0.1
 * IK Analyzer release 5.0.1
 * 
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * 源代码由林良益(linliangyi2005@gmail.com)提供
 * 版权声明 2012，乌龙茶工作室
 * provided by Linliangyi and copyright 2012 by Oolong studio
 * 
 */
package org.wltea.analyzer.lucene;

import org.apache.lucene.analysis.Analyzer;

/**
 * IK分词器，Lucene Analyzer接口实现
 * 兼容Lucene 4.0版本
 */
public final class IKAnalyzer extends Analyzer {
	
	private Boolean useSmart;
	
	public Boolean useSmart() {
		return useSmart;
	}

	public void setUseSmart(Boolean useSmart) {
		this.useSmart = useSmart;
	}

	/**
	 * IK分词器Lucene Analyzer接口实现类
	 * 
	 * 默认使用 xml 中配置的切分算法
	 */
	public IKAnalyzer(){
        super();
	}

	/**
	 * IK分词器Lucene Analyzer接口实现类
	 * 
	 * @param useSmart 当为 true 时，分词器进行智能切分；反之进行最细粒度切分
	 */
	public IKAnalyzer(boolean useSmart){
		super();
		this.useSmart = useSmart;
	}

	/**
	 * 重载Analyzer接口，构造分词组件
	 */
	@Override
	protected TokenStreamComponents createComponents(String fieldName) {
        if (this.useSmart == null) {
			return new TokenStreamComponents(new IKTokenizer());
		} else {
			return new TokenStreamComponents(new IKTokenizer(this.useSmart));
		}
	}
}
