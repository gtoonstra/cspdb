
// line 1 "./rl/parser.rl"
/*
 * @LANG: java
 */
 
package com.blogspot.radialmind.csp.parser;

import java.util.Vector;

public class Parser
{
	private ICSPEngine engine;
	private int line = 0;
	
	
// line 67 "./rl/parser.rl"


	
// line 22 "./src/main/java/com/blogspot/radialmind/csp/parser/Parser.java"
private static byte[] init__Parser_actions_0()
{
	return new byte [] {
	    0,    1,    0,    1,    1,    1,    2,    1,    3,    1,    4,    2,
	    0,    2,    2,    2,    0
	};
}

private static final byte _Parser_actions[] = init__Parser_actions_0();


private static byte[] init__Parser_key_offsets_0()
{
	return new byte [] {
	    0,    0,    5,    8,   16,   21,   29,   30,   33,   36,   41,   46,
	   52,   53,   56,   57,   68,   79
	};
}

private static final byte _Parser_key_offsets[] = init__Parser_key_offsets_0();


private static char[] init__Parser_trans_keys_0()
{
	return new char [] {
	    9,   32,   34,   40,   41,    9,   32,   40,    9,   32,   34,   40,
	   41,   46,   48,   57,    9,   32,   34,   40,   41,    9,   32,   34,
	   40,   41,   46,   48,   57,   34,    9,   32,   41,    9,   32,   59,
	    9,   10,   13,   32,  133,    9,   10,   13,   32,  133,    9,   10,
	   13,   32,   40,  133,   34,    9,   32,   40,   59,    9,   10,   13,
	   32,   34,   46,  133,   40,   41,   48,   57,    9,   10,   13,   32,
	   34,   46,  133,   40,   41,   48,   57,    9,   10,   13,   32,   34,
	   40,   41,  133,    0
	};
}

private static final char _Parser_trans_keys[] = init__Parser_trans_keys_0();


private static byte[] init__Parser_single_lengths_0()
{
	return new byte [] {
	    0,    5,    3,    6,    5,    6,    1,    3,    3,    5,    5,    6,
	    1,    3,    1,    7,    7,    8
	};
}

private static final byte _Parser_single_lengths[] = init__Parser_single_lengths_0();


private static byte[] init__Parser_range_lengths_0()
{
	return new byte [] {
	    0,    0,    0,    1,    0,    1,    0,    0,    0,    0,    0,    0,
	    0,    0,    0,    2,    2,    0
	};
}

private static final byte _Parser_range_lengths[] = init__Parser_range_lengths_0();


private static byte[] init__Parser_index_offsets_0()
{
	return new byte [] {
	    0,    0,    6,   10,   18,   24,   32,   34,   38,   42,   48,   54,
	   61,   63,   67,   69,   79,   89
	};
}

private static final byte _Parser_index_offsets[] = init__Parser_index_offsets_0();


private static byte[] init__Parser_indicies_0()
{
	return new byte [] {
	    1,    1,    2,    3,    2,    0,    4,    4,    5,    2,    5,    5,
	    7,    2,    8,    2,    2,    6,    9,    9,    2,    2,   10,    6,
	   11,   11,    7,    2,   12,    2,    2,    6,   14,   13,   15,   15,
	   16,    2,   12,   12,   17,    2,   17,   18,   19,   17,   18,    2,
	   20,   18,   19,   20,   18,    2,   21,   18,   19,   21,    5,   18,
	    2,   23,   22,   24,   24,   25,    2,   17,    2,   20,   26,   26,
	   20,   27,    2,   26,    2,    2,    0,   20,   28,   26,   20,   27,
	    2,   26,    2,    2,    0,   29,   26,   26,   29,   27,    3,    2,
	   26,    0,    0
	};
}

private static final byte _Parser_indicies[] = init__Parser_indicies_0();


private static byte[] init__Parser_trans_targs_0()
{
	return new byte [] {
	    1,    2,    0,    3,    2,    3,    4,    6,   14,    5,    8,    5,
	    8,    6,    7,    5,    8,    9,   15,   16,   10,   11,   12,   13,
	    2,    3,   17,   12,   17,   11
	};
}

private static final byte _Parser_trans_targs[] = init__Parser_trans_targs_0();


private static byte[] init__Parser_trans_actions_0()
{
	return new byte [] {
	    5,    7,    0,    7,    0,    0,    5,    0,    0,    7,    7,    0,
	    0,    5,    0,    9,    9,    3,    1,    1,    0,    0,    5,    0,
	    9,    9,   14,    0,   11,    7
	};
}

private static final byte _Parser_trans_actions[] = init__Parser_trans_actions_0();


static final int Parser_start = 15;
static final int Parser_first_final = 15;
static final int Parser_error = 0;

static final int Parser_en_main = 15;


// line 70 "./rl/parser.rl"

	public boolean parse( ICSPEngine engine, char data[] )
	{
		int cs, p = 0, pe = data.length;
		int top = 0;
		int stack[] = new int[ 16384 ];
		
		this.engine = engine;
		engine.reset();

		try {

			
// line 158 "./src/main/java/com/blogspot/radialmind/csp/parser/Parser.java"
	{
	cs = Parser_start;
	}

// line 83 "./rl/parser.rl"
			
// line 165 "./src/main/java/com/blogspot/radialmind/csp/parser/Parser.java"
	{
	int _klen;
	int _trans = 0;
	int _acts;
	int _nacts;
	int _keys;
	int _goto_targ = 0;

	_goto: while (true) {
	switch ( _goto_targ ) {
	case 0:
	if ( p == pe ) {
		_goto_targ = 4;
		continue _goto;
	}
	if ( cs == 0 ) {
		_goto_targ = 5;
		continue _goto;
	}
case 1:
	_match: do {
	_keys = _Parser_key_offsets[cs];
	_trans = _Parser_index_offsets[cs];
	_klen = _Parser_single_lengths[cs];
	if ( _klen > 0 ) {
		int _lower = _keys;
		int _mid;
		int _upper = _keys + _klen - 1;
		while (true) {
			if ( _upper < _lower )
				break;

			_mid = _lower + ((_upper-_lower) >> 1);
			if ( data[p] < _Parser_trans_keys[_mid] )
				_upper = _mid - 1;
			else if ( data[p] > _Parser_trans_keys[_mid] )
				_lower = _mid + 1;
			else {
				_trans += (_mid - _keys);
				break _match;
			}
		}
		_keys += _klen;
		_trans += _klen;
	}

	_klen = _Parser_range_lengths[cs];
	if ( _klen > 0 ) {
		int _lower = _keys;
		int _mid;
		int _upper = _keys + (_klen<<1) - 2;
		while (true) {
			if ( _upper < _lower )
				break;

			_mid = _lower + (((_upper-_lower) >> 1) & ~1);
			if ( data[p] < _Parser_trans_keys[_mid] )
				_upper = _mid - 2;
			else if ( data[p] > _Parser_trans_keys[_mid+1] )
				_lower = _mid + 2;
			else {
				_trans += ((_mid - _keys)>>1);
				break _match;
			}
		}
		_trans += _klen;
	}
	} while (false);

	_trans = _Parser_indicies[_trans];
	cs = _Parser_trans_targs[_trans];

	if ( _Parser_trans_actions[_trans] != 0 ) {
		_acts = _Parser_trans_actions[_trans];
		_nacts = (int) _Parser_actions[_acts++];
		while ( _nacts-- > 0 )
	{
			switch ( _Parser_actions[_acts++] )
			{
	case 0:
// line 17 "./rl/parser.rl"
	{ line++; engine.reset(); }
	break;
	case 1:
// line 19 "./rl/parser.rl"
	{
			engine.execute();
		}
	break;
	case 2:
// line 24 "./rl/parser.rl"
	{
			engine.appendChar( data[p] );
		}
	break;
	case 3:
// line 29 "./rl/parser.rl"
	{
			engine.finishWord();
		}
	break;
	case 4:
// line 33 "./rl/parser.rl"
	{
			engine.finishString();
		}
	break;
// line 273 "./src/main/java/com/blogspot/radialmind/csp/parser/Parser.java"
			}
		}
	}

case 2:
	if ( cs == 0 ) {
		_goto_targ = 5;
		continue _goto;
	}
	if ( ++p != pe ) {
		_goto_targ = 1;
		continue _goto;
	}
case 4:
case 5:
	}
	break; }
	}

// line 84 "./rl/parser.rl"
			
		} catch (EngineException ee) {
			ee.printStackTrace();
			return false;
		}

		if (( cs >= Parser_first_final ) && ( top == 0 ))
			return true;
		else
			return false;
	}
}
