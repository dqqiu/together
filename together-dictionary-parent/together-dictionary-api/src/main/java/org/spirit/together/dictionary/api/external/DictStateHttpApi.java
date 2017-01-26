package org.spirit.together.dictionary.api.external;

import org.spirit.together.dictionary.api.vo.DictStateVo;

public interface DictStateHttpApi {
  DictStateVo getStateByCd(String cd);
}
